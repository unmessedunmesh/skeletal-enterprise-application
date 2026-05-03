package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.joda.time.DateTime;


/**
 * The parent class for all reference entities (i.e. reference data as opposed to transactional data).
 *
 * @see TransactionalEntity
 *
 * @author MohammadReza Alagheband
 */
@MappedSuperclass
@Data
public class ReferenceEntity implements Serializable {

    /**
     * The default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The primary key identifier.
     */
    @Id
    private Long id;

    /**
     * The unique code value, sometimes used for external reference.
     */
    @NotNull
    private String code;

    /**
     * A brief description of the entity.
     */
    @NotNull
    private String label;

    /**
     * The ordinal value facilitates sorting the entities.
     */
    @NotNull
    private Integer ordinal;

    /**
     * The timestamp at which the entity's values may be applied or used by the system.
     */
    @NotNull
    private Timestamp effectiveAt;

    /**
     * The timestamp at which the entity's values cease to be used by the system. If <code>null</code> the entity is not
     * expired.
     */
    private Timestamp expiresAt;

    /**
     * The timestamp when this entity instance was created.
     */
    @NotNull
    private Timestamp createdAt;



}
