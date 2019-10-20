package com.mmihaylov.rest.services;

import com.mmihaylov.rest.model.Campaign;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

final class CampaignsServiceImpl implements CampaignsService, GetResponseApiService {

    protected CampaignsServiceImpl() {

    }

    @Override
    public List<Campaign> getCampaignList() {
        Response respone = client.target(GET_RESPONSE_API)
                .path("campaigns")
                .request(MediaType.APPLICATION_JSON)
                .header("X-Auth-Token", API_KEY)
                .get();
        return respone.readEntity(new GenericType<List<Campaign>>(){});
    }
}
