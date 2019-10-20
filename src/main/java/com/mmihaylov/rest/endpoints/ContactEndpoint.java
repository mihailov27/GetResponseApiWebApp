package com.mmihaylov.rest.endpoints;

import com.mmihaylov.rest.model.Contact;
import com.mmihaylov.rest.services.ContactsService;
import com.mmihaylov.rest.services.ServicesFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/contacts")
public class ContactEndpoint {

    /**
     * Creates a new contact (pre-process validation).
     * @param contact
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createContact(Contact contact) {
        ContactsService contactsService = ServicesFactory.getContactsService();
        String validationMsg = contactsService.validateContact(contact);
        if (validationMsg != null) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("msg", validationMsg);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(responseMap).type(MediaType.APPLICATION_JSON).build();
        }

        contactsService.createContact(contact);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * Returns a list of contacts.
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContacts() {
        ContactsService contactsService = ServicesFactory.getContactsService();
        return Response.ok()
                .type(MediaType.APPLICATION_JSON)
                .entity(contactsService.getContacts())
                .build();
    }
}
