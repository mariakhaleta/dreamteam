package com.example.mariakhaleta.booksstore;

public class Store {

    private String title;
    private String contacts;
    private String openHour;

    public Store(String title, String contacts, String openHour) {
        this.title = title;
        this.contacts = contacts;
        this.openHour = openHour;
    }

    public String getTitle() {
        return title;
    }

    public String getContacts() {
        return contacts;
    }

    public String getOpenHour() {
        return openHour;
    }
}
