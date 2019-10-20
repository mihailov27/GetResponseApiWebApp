package com.mmihaylov.rest.services;

import com.mmihaylov.rest.model.Campaign;
import com.mmihaylov.rest.model.Contact;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class ContactsServiceTest {

    @Test
    public void getContactsTest() {
        List<Contact> contacts = ServicesFactory.getContactsService().getContacts();
        Assert.assertNotNull(contacts);
    }

    @Ignore
    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        Campaign campaign = new Campaign();
        campaign.setId("W1nAs");
        contact.setCampaign(campaign);
        contact.setEmail("msmihaylov89@gmail.com");
        contact.setName("Mihail Mihaylov");
        ServicesFactory.getContactsService().createContact(contact);
    }
}
