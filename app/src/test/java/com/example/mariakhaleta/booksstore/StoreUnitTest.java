package com.example.mariakhaleta.booksstore;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class StoreUnitTest {
    private Store mStore;

    private static final String TITLE ="Букварь";
    private static final String CONTACTS = "38099333283";
    private static final String OPENHOUR = "10:00-18:00";

    @Before
    public void init_store() {
        mStore = new Store(TITLE, CONTACTS, OPENHOUR);
    }

    @Test
    public void store_init_negative() {
        Store store = null;

        assertNull(store);
    }


    @Test
    public void store_init_positive() {
        assertNotNull(mStore);
    }

    @Test
    public void store_title_positive() {
        assertEquals(mStore.getTitle(), TITLE);
    }

    @Test
    public void store_title_negative() {
        String Title = "";

        assertNotEquals(mStore.getTitle(), Title);
    }

    @Test
    public void store_contacts_positive() {
        assertEquals(mStore.getContacts(), CONTACTS);
    }

    @Test
    public void store_contacts_negative() {
        String Contacts = "";

        assertNotEquals(mStore.getContacts(), Contacts);
    }

    @Test
    public void store_openhour_positive() {
        assertEquals(mStore.getOpenHour(), OPENHOUR);
    }

    @Test
    public void store_openhour_negative() {
        String OpenHour = "";

        assertNotEquals(mStore.getOpenHour(), OpenHour);
    }
}
