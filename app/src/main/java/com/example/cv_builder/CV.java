package com.example.cv_builder;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class CV {

    private String name;
    private String email;

    private String phone;

    private String summary;

    private ArrayList<String> education;

    private Uri uri;

    private ArrayList<String> experience;

    private ArrayList<String> refer;

    private ArrayList<String> certs;

    public CV(String name, String email, String phone, String summary, ArrayList<String> education, Uri uri, ArrayList<String> experience, ArrayList<String> refer,ArrayList<String> certs) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.summary = summary;
        this.education = education;
        this.uri = uri;
        this.experience = experience;
        this.refer = refer;
        this.certs = certs;
    }

    public CV() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public ArrayList<String> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<String> experience) {
        this.experience = experience;
    }

    public ArrayList<String> getRefer() {
        return refer;
    }

    public void setRefer(ArrayList<String> refer) {
        this.refer = refer;
    }

    public ArrayList<String> getCerts() {
        return certs;
    }

    public void setCerts(ArrayList<String> certs) {
        this.certs = certs;
    }
}
