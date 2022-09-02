package com.example.sqlsandbox.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public abstract class BaseEntity implements Cloneable, Serializable {

    @Column(name= "id")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
}
