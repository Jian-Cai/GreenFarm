package org.csu.greenfarm.domain;

import java.math.BigDecimal;

public class FarmLocation implements java.io.Serializable {
    private String farmId;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
