package com.example.mariakhaleta.booksstore;

public class Users {

    private Integer UserID;
    private String Name;
    private String LastName;
    private String PhoneNumber;
    private String Birthday;
    private String Email;

    public Users(Integer bookID, String name, String lastName, String phoneNumber, String birthday, String email) {
        UserID = bookID;
        Name = name;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Birthday = birthday;
        Email = email;
    }

    public Integer getUserID() {
        return UserID;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getEmail() {
        return Email;
    }
}
