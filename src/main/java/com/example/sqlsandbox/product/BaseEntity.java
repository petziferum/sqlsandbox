package com.example.sqlsandbox.product;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
public abstract class BaseEntity implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name= "id")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
}
