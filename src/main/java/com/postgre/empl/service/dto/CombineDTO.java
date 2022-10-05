package com.postgre.empl.service.dto;


import com.postgre.empl.model.Combine;
import lombok.Data;

@Data
public class CombineDTO {

    private long id;
    private long empid;
    private long compid;

    public CombineDTO(Combine combine) {
        this.setId(combine.getId());
        this.setEmpid(combine.getempid());
        this.setCompid(combine.getcompid());
    }
}
