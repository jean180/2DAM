package com.example.crm_leads;

import java.util.UUID;

public class Lead {
    private String mID, mName, mTitle, mCompany;
    private int mImage;

    public Lead(String name, String title, String company, int image){
        mID = UUID.randomUUID().toString();
        mName = name;
        mTitle = title;
        mCompany = company;
        mImage = image;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "mID='" + mID + '\'' +
                ", mName='" + mName + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mCompany='" + mCompany + '\'' +
                ", mImage=" + mImage +
                '}';
    }
}
