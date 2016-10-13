package com.example.online;

public class Contacts2
{
   // private String name,email,mobile;
 private String dated;



    public Contacts2(String dated)
    {
        this.setDated(dated);
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }
}
