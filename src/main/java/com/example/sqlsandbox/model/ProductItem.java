package com.example.sqlsandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductItem {

    @Id
    private String id;
    private String name;
    private String description;
    private String properties;
}
