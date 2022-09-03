package com.example.sqlsandbox.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = ProductItem.TABLE_NAME)
@AllArgsConstructor
@Data
@Builder
public class ProductItem {

    public static final String TABLE_NAME = "products";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String description;
    private String properties;

    @ElementCollection
    @CollectionTable(name = "product_class", joinColumns = @JoinColumn(name = "productid")) //Mit JoinColum wird die Verbindung zur Entity hergestellt
    @Builder.Default
    private List<ItemClass> itemClasses = new ArrayList<>();

    public ProductItem() {
    }
}
