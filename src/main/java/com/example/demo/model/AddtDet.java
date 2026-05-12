package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class AddtDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String rfpNumber;


    private String viewName;




}
