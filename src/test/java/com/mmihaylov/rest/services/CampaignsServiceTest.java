package com.mmihaylov.rest.services;

import com.mmihaylov.rest.model.Campaign;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CampaignsServiceTest {

    @Test
    public void getCampaignListTest() {
        List<Campaign> campaigns = ServicesFactory.getCampaignsService().getCampaignList();
        Assert.assertNotNull(campaigns);
        Assert.assertTrue(campaigns.size() > 0);
    }
}
