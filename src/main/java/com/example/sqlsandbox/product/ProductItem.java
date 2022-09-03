package com.example.sqlsandbox.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ProductItem.TABLE_NAME)
@AllArgsConstructor
@Data
@Builder
public class ProductItem {

    public static final String TABLE_NAME = "products";

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String description;
    private String properties;

    public ProductItem() {
    }
}
