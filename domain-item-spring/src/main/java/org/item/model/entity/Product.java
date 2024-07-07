package org.item.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.item.model.common.CommonProduct;

@Entity
@Table(name = "TB_PRODUCT")
@NoArgsConstructor
@ToString
@Getter
public class Product implements CommonProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;


    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
