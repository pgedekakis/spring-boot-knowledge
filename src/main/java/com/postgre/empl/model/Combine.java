package com.postgre.empl.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "combine")
public class Combine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "empid")
    private long empid;

    @Column(name = "compid")
    private long compid;


    public Combine() {

    }

    public Combine(long empid, long compid) {
        super();
        this.empid = empid;
        this.compid = compid;


    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getempid() {
        return empid;
    }
    public void setempid(long empid) {
        this.empid = empid;
    }
    public long getcompid() {
        return compid;
    }
    public void setcompid(long compid) {
        this.compid = compid;
    }

}
