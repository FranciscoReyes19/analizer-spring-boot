package com.web.analizer.payload;

import javax.validation.constraints.*;

public class ExpedienteRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 40)
    private String adn;

    @NotBlank
    private Boolean result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}