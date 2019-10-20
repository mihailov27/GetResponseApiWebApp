package com.mmihaylov.rest.endpoints;

import com.mmihaylov.rest.model.Campaign;
import com.mmihaylov.rest.services.ServicesFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/campaigns")
public class CampaignEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCampaigns() {
        List<Campaign> campaigns = ServicesFactory.getCampaignsService().getCampaignList();
        return Response.ok().entity(campaigns)
                .type(MediaType.APPLICATION_JSON).build();
    }

}
