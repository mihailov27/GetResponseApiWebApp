package com.mmihaylov.rest.services;

import com.mmihaylov.rest.model.Contact;

import java.util.List;

public interface ContactsService {

    String validateContact(Contact contact);

    void createContact(Contact createContact);

    List<Contact> getContacts();
}
