package com.grupo07.banca.proyecto01.personal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties({"model", "seatingCapacity"})
public class Personal {

    @Id
    protected String _id;
    private String dni;
    private String name;
    private String fatherLastname;
    private String motherLastname;
    private String gender;
    private Integer age;
    protected Date creationDate;
    protected Boolean isActive;
}