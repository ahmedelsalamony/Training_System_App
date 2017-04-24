package com.example.ahmed.training_system_app.company;

/**
 * Created by Mahmoud on 23/04/2017.
 */

public class RequestItems {

    private  String Name;
    private  String phone;
    private  String email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RequestItems(String name, String phone, String email){
        super();

        this.Name=name;
        this.phone=phone;
        this.email=email;

    }


}
