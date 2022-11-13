package com.example.demo;

import java.io.Serializable;

public class AirportID implements Serializable {

    private String countryCode;

    private String cityCode;

    // getters & setters equals, hashCode

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
        result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AirportID other = (AirportID) obj;
        if (countryCode == null) {
            if (other.countryCode != null)
                return false;
        } else if (!countryCode.equals(other.countryCode))
            return false;
        if (cityCode == null) {
            if (other.cityCode != null)
                return false;
        } else if (!cityCode.equals(other.cityCode))
            return false;
        return true;
    }

}
