package com.nordstrom.hackathon.matchmaker.service.controllers;

import com.nordstrom.hackathon.matchmaker.service.models.NordResponse;
import com.nordstrom.hackathon.matchmaker.service.services.MatcherService;
import com.nordstrom.hackathon.matchmaker.service.services.NordResponseService;
import com.nordstrom.hackathon.matchmaker.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ResponseController {

    private ProductService productService;
    private NordResponseService nordResponseService;
    private MatcherService matcherService;

    @Autowired
    public ResponseController(ProductService productService,
                              NordResponseService nordResponseService,
                              MatcherService matcherService) {

        this.productService = productService;
        this.nordResponseService = nordResponseService;
        this.matcherService = matcherService;
    }

    @GET
    @Path("products")
    public Response getProducts() {

        String body;
        try {
            body = productService.getProductsJson();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
        return Response.ok(body, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("matches")
    public Response getMatches(@QueryParam("username") String username) {

        if (username == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Must specify username")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        String matchJson = matcherService.getMatchesJson(username);
        return Response.ok().entity(matchJson).type(MediaType.APPLICATION_JSON).build();
    }

    /**
     * Post the user response to a product view.
     *
     * @param user The username of the response
     * @param productId The product ID
     * @param value "like", "dislike" or "buy"
     * @return a response
     */
    @POST
    @Path("response")
    public Response setResponse(
            @QueryParam("username") String user,
            @QueryParam("productId") int productId,
            @QueryParam("value") String value) {

        if ((user == null) || (value == null) || productId <= 0 ) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Must specify both 'username' and 'value'.  'productId' must be a positive integer")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

        if (!(value.equals("like") || value.equals("dislike") || value.equals("buy"))) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("value must be one of 'like', 'dislike' or 'buy'.")
                    .type("text/plain")
                    .build();

        }

        NordResponse nordResponse = new NordResponse();
        nordResponse.setUsername(user);
        nordResponse.setProductId(productId);
        nordResponse.setValue(value);

        nordResponseService.addResponse(nordResponse);

        return Response.ok().build();
    }

    @DELETE
    @Path("responses")
    public Response deleteResponses(@QueryParam("username") String username) {

        nordResponseService.deleteUser(username);
        return Response.ok().build();
    }

}
