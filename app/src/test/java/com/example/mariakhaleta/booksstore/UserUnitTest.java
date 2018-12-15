package com.example.mariakhaleta.booksstore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserUnitTest {

    private Users mUsers;

    private static final Integer USERID = 1;
    private static final String NAME = "Маша";
    private static final String LASTNAME = "Халета";
    private static final String PHONENUMBER= "38067222333";
    private static final String BIRTHDAY = "1999.03.15";
    private static final String EMAIL = "mariakhaleta@gmail.com";

    @Before
    public void init_users() {
        mUsers = new Users(USERID, NAME, LASTNAME, PHONENUMBER, BIRTHDAY, EMAIL);
    }

    @Test
    public void users_init_negative() {
        Users users = null;

        assertNull(users);
    }

    @Test
    public void users_init_positive() {
        assertNotNull(mUsers);
    }

    @Test
    public void users_user_id_positive() {
        assertEquals(mUsers.getUserID(), USERID);
    }

    @Test
    public void users_user_id_negative() {
        String UserID = "";

        assertNotEquals(mUsers.getUserID(), UserID);
    }

    @Test
    public void users_name_positive() {
        assertEquals(mUsers.getName(), NAME);
    }

    @Test
    public void users_name_negative() {
        String Name= "";

        assertNotEquals(mUsers.getName(), Name);
    }

    @Test
    public void users_last_name_positive() {
        assertEquals(mUsers.getLastName(), LASTNAME);
    }

    @Test
    public void users_last_name_negative() {
        String LastName = "";

        assertNotEquals(mUsers.getLastName(), LastName);
    }

    @Test
    public void users_phonenumber_positive() {
        assertEquals(mUsers.getPhoneNumber(), PHONENUMBER);
    }

    @Test
    public void users_phonenumber_negative() {
        String PhoneNumber = "";

        assertNotEquals(mUsers.getPhoneNumber(), PhoneNumber);
    }

    @Test
    public void users_birthday_positive() {
        assertEquals(mUsers.getBirthday(), BIRTHDAY);
    }

    @Test
    public void users_birthday_negative() {
        String Birthday = "";

        assertNotEquals(mUsers.getBirthday(), Birthday);
    }

    @Test
    public void users_email_positive() {
        assertEquals(mUsers.getEmail(), EMAIL);
    }

    @Test
    public void users_email_negative() {
        String Email = "";

        assertNotEquals(mUsers.getEmail(), Email);
    }
}
