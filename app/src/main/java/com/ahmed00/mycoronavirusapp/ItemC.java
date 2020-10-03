package com.ahmed00.mycoronavirusapp;

public class ItemC {
    private String flag,country,cases,deaths,recovered,active,dangerous;

    public ItemC() {
    }

    public ItemC(String flag, String country, String cases, String deaths, String recovered, String active, String dangerous) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.dangerous = dangerous;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDangerous() {
        return dangerous;
    }

    public void setDangerous(String dangerous) {
        this.dangerous = dangerous;
    }
}
