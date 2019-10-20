package com.mmihaylov.rest.services;

public final class ServicesFactory {

    private ServicesFactory() {

    }

    public static ContactsService getContactsService() {
        return new ContactsServiceImpl();
    }

    public static CampaignsService getCampaignsService() {
        return new CampaignsServiceImpl();
    }
}
