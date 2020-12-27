package com.example.proiectaz;

public class DetaliiOrase  {

    private String city;
    private float lat;
    private float lng;
    private String country;
    private String iso2;
    private String adminName;
    private String capital;
    private int population;
    private int populationProper;

    public DetaliiOrase(String city, float lat, float lng, String country, String iso2, String adminName, String capital, int population, int populationProper) {
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.iso2 = iso2;
        this.adminName = adminName;
        this.capital = capital;
        this.population = population;
        this.populationProper = populationProper;
    }

    @Override
    public String toString() {
        return "Detalii Orase{" +
                "city='" + city + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", country='" + country + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", adminName='" + adminName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", populationProper=" + populationProper +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulationProper() {
        return populationProper;
    }

    public void setPopulationProper(int populationProper) {
        this.populationProper = populationProper;
    }
}
