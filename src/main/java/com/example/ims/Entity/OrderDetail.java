package com.example.ims.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "OrderDetail")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ItemID", nullable = false)
    private Item item;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

}
