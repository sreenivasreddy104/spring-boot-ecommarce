package com.happycoding.ecommarce.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "code")
    String code;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "country")
    List<State> states;
}
