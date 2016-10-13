package com.example.online;

public class Contacts3
{
   // private String name,email,mobile;
 private  String adhar_id,date,hospital_name,hospital_id,doctor_name,diseases,special_remarks,medication;



    public Contacts3(String adhar_id,String date,String hospital_name,String hospital_id,String doctor_name,String diseases,String special_remarks,String medication)
    {
        this.setAdhar_id(adhar_id);
        this.setDate(date);
        this.setHospital_name(hospital_name);
        this.setHospital_id(hospital_id);
        this.setDoctor_name(doctor_name);
        this.setDiseases(diseases);
        this.setSpecial_remarks(special_remarks);
        this.setMedication(medication);
    }

    public String getAdhar_id() {
        return adhar_id;
    }

    public void setAdhar_id(String adhar_id) {
        this.adhar_id = adhar_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getSpecial_remarks() {
        return special_remarks;
    }

    public void setSpecial_remarks(String special_remarks) {
        this.special_remarks = special_remarks;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }
}
