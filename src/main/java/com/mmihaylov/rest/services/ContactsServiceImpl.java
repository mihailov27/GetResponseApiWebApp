package com.mmihaylov.rest.services;

import com.mmihaylov.rest.model.Contact;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

final class ContactsServiceImpl implements GetResponseApiService, ContactsService {

    protected ContactsServiceImpl() {

    }

    @Override
    public String validateContact(Contact contact) {
        if (contact == null) {
            return CreateContactMessages.NO_DATA;
        }
        if (StringUtils.isBlank(contact.getName())) {
            return CreateContactMessages.NO_NAME;
        }
        if (StringUtils.isBlank(contact.getEmail())) {
            return CreateContactMessages.NO_EMAIL;
        }
        if (contact.getCampaign() == null ||
                StringUtils.isBlank(contact.getCampaign().getId())) {
            return CreateContactMessages.NO_COMPAIGN;
        }
        return null;
    }

    @Override
    public void createContact(Contact createContact) {
        Response response = client.target(GET_RESPONSE_API)
                .path("contacts")
                .request(MediaType.APPLICATION_JSON)
                .header("X-Auth-Token", API_KEY)
                .post(Entity.entity(createContact, MediaType.APPLICATION_JSON));

        if (response.getStatus() != 202) {
            String msg = response.readEntity(String.class);
            throw new IllegalStateException("Failed to create a contact: Status "
                    + response.getStatus() + ", message:\n" + msg);
        }
    }

    @Override
    public List<Contact> getContacts() {
        Response respone = client.target(GET_RESPONSE_API)
                .path("contacts")
                .request(MediaType.APPLICATION_JSON)
                .header("X-Auth-Token", API_KEY)
                .get();
        return respone.readEntity(new GenericType<List<Contact>>(){});
    }

    private interface CreateContactMessages {

        String NO_DATA = "The data is null";

        String NO_NAME = "The contact's name is not set.";

        String NO_EMAIL = "The contact's email is not set.";

        String NO_COMPAIGN = "The contact's campaign is not set.";
    }
}
