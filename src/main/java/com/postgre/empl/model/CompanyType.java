package com.postgre.empl.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "company_type")
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_id")
    private long compid;

    @Column(name = "type")
    private String cotype;


    public CompanyType() {

    }

    public CompanyType(String cotype, long compid) {
        super();
        this.cotype = cotype;
        this.compid = compid;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getcotype() {
        return cotype;
    }

    public void setcotype(String cotype) {
        this.cotype = cotype;
    }

    public long getcompid() {
        return compid;
    }

    public void setcompid(long compid) {
        this.compid = compid;
    }
}
