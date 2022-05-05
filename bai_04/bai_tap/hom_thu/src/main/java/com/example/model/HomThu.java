package com.example.model;

public class HomThu {
    private String languages;
    private int pageSize;
    private boolean spamFillter;
    private String signature;

    public HomThu() {
    }

    public HomThu(String languages, int pageSize, boolean spamFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFillter = spamFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFillter() {
        return spamFillter;
    }

    public void setSpamFillter(boolean spamFillter) {
        this.spamFillter = spamFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
