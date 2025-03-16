package com.example.cv_builder;

import android.net.Uri;

import java.util.List;

public class CV {

    private String name;
    private String email;

    private String phone;

    private String summary;

    private List<String> education;

    private Uri uri;

    private List<String> experience;

    private List<String> refer;

    private List<String> certs;

    public CV(String name, String email, String phone, String summary, List<String> education, Uri uri, List<String> experience, List<String> refer,List<String> certs) {
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

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getRefer() {
        return refer;
    }

    public void setRefer(List<String> refer) {
        this.refer = refer;
    }

    public List<String> getCerts() {
        return certs;
    }

    public void setCerts(List<String> certs) {
        this.certs = certs;
    }
}
