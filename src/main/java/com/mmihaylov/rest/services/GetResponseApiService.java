package com.mmihaylov.rest.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

interface GetResponseApiService {

    /**
     * API key for GetResponseAPI.
     */
    String API_KEY = "api-key vnxwslhdc90ppfptgbbhk7xoq7ruaub4";

    /**
     * GetResponse API root.
     */
    String GET_RESPONSE_API = "https://api.getresponse.com/v3";

    /**
     * HTTP client
     */
    Client client = ClientBuilder.newClient();

}
