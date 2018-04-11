package com.example.gourav.retrivedata;

public class Blog {
    private String Aphone,name,email,phone,message;

    public Blog(String Aphone, String name, String email, String phone, String message) {
        this.Aphone = Aphone;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

public  Blog(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAphone() {
        return Aphone;
    }

    public void setAphone(String aphone) {
        Aphone = aphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
