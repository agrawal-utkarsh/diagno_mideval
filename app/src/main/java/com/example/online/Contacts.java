package com.example.online;

public class Contacts
{
   // private String name,email,mobile;
 private  String adhar_id,name,age,residence,gender,profile_pic;



    public Contacts(String adhar_id,String name,String age,String residence,String gender,String profile_pic)
    {
        this.setAdhar_id(adhar_id);
        this.setName(name);
        this.setAge(age);
        this.setResidence(residence);
        this.setGender(gender);
        this.setProfile_pic(profile_pic);
    }

    public String getAdhar_id() {
        return adhar_id;
    }

    public void setAdhar_id(String adhar_id) {
        this.adhar_id = adhar_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
}
