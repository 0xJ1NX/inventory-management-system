package com.example.ims.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "supply")
public class Supply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ItemID", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SupplierID", nullable = false)
    private Supplier supplier;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "PPU", nullable = false, precision = 10, scale = 2)
    private BigDecimal ppu; // Price Per Unit

    @Column(name = "Date", nullable = false)
    private Date date;

}
