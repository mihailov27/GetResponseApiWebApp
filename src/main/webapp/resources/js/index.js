
var campaigns_url = '../rest/campaigns';

var contact_url = '../rest/contacts';

$(document).ready(function() {
    loadCampaigns();
    attachHandlers();
    reloadContacts();
});

var loadCampaigns = function() {
    $.get(campaigns_url, function(campaigns) {
        campaigns.forEach(function(campaign) {
            $('#campaign').append($('<option>', {
                value: campaign.campaignId, text : campaign.name + ' (' + campaign.description + ')'
            }));
        });
        $('#create-contact-form').show();
    });
}

var attachHandlers = function() {
    $("#create-contact-form" ).submit(function(event) {
        event.preventDefault();
        createNewContact();
    });

    $('#clearBtn').click(function() {
        $('#name').val('');
        $('#email').val('');
        $('#campaign').val('');
    });

    $('#getContacts').click(function() {
        reloadContacts();
    });
}

var createNewContact = function() {
    var contact = {};
    contact['name'] = $('#name').val();
    contact['email'] = $('#email').val();
    contact['campaign'] = {};
    contact['campaign']['campaignId'] = $('#campaign').val();
    var data = JSON.stringify(contact);

    var responseCallback = function(responseData, status){
        console.log('Data: ' + responseData);
        console.log('Status: ' + status);
    };

    $.ajax({
        url:contact_url,
        type:"POST",
        data:data,
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: responseCallback
    }).done(function(data, statusText, xhr){
         if (xhr.status == 201) {
            alert('Success! The contact is created.');
         } else {
            alert('Server error! The contact was NOT created.');
         }
     });
}

var reloadContacts = function() {
    $('#contactsPanel').empty();

    $('#contactsCount').empty();

    $.get(contact_url, function(contacts) {

        $('#contactsCount').text('Number of contacts: ' + contacts.length);

        contacts.forEach(function(contact) {
            $('#contactsPanel').append($(
                  '<div>' + 'Name: ' + contact.name + '<br>' +
                  'Campaign: ' + contact.campaign.name + '<br>' +
                  'Email: ' + contact.email + '</div><br/>'
            ));
        });
    });
};