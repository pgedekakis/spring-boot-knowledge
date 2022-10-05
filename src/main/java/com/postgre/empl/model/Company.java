package com.postgre.empl.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name")
    private String cName;

    @Column(name = "company_afm")
    private String cAfm;

    @Column(name = "company_phone")
    private String cPhone;

    @Column(name = "establishment_year")
    private Date cYear;

    public Company() {

    }

    public Company(String cName, String cAfm, Date cYear, String cPhone) {
        super();
        this.cName = cName;
        this.cAfm = cAfm;
        this.cPhone = cPhone;
        this.cYear = cYear;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getcAfm() {
        return cAfm;
    }
    public void setcAfm(String cAfm) {
        this.cAfm = cAfm;
    }
    public Date getcYear() {
        return cYear;
    }
    public void setcYear(Date cYear) {
        this.cYear = cYear;
    }
    public String getcPhone() {
        return cPhone;
    }
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}
