package com.web.analizer.model;

import com.web.analizer.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "expedientes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "adn"
        })
})
public class Expediente extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    private String adn;
    
    private Boolean result;

    public Expediente() {

    }

    public Expediente(String name, String adn, Boolean result) {
        this.name = name;
        this.adn = adn;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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