package com.example.ims.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;




@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long supplierId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Email", nullable = false)
    private String email;

}
