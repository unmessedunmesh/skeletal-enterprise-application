package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mapping.PersistentEntity;

/**
 * The Role class is an entity model object. A Role describes a privilege level within the application. A Role is used
 * to authorize an Account to access a set of application resources.
 *
 * @author MohammadReza Alagheband
 */
@Entity
@Data
public class Role extends ReferenceEntity {

    private static final long serialVersionUID = 1L;

}

