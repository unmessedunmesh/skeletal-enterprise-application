package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity
@Data
public class RFP {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    private String rfpNumber;

    private String imdCode;

    @OneToMany(targetEntity = Policy.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "RP_FK", referencedColumnName = "rfpNumber")
    private Set<Policy> policies;

    @OneToMany(targetEntity = AddtDet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "RA_FK", referencedColumnName = "rfpNumber")
    private Set<AddtDet> addtDets;
}
