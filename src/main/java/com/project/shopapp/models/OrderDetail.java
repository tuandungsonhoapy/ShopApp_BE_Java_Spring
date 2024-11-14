package com.project.shopapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    @Min(value = 1)
    private int quantity;

    @Column(name = "price", nullable = false)
    @Min(value = 0)
    private Float price;

    @Column(name = "total", nullable = false)
    @Min(value = 0)
    private Float total;

    @Column(name = "color", length = 20)
    private String color;
}
