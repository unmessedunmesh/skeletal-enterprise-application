package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 * The Account class is an entity model object. An Account describes the security credentials and authentication flags
 * that permit access to application functionality.
 *
 * @author MohammadReza Alagheband
 */
@Entity
@Data
public class Account extends TransactionalEntity implements UserDetails {


    private static final long serialVersionUID = 1L;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean enabled = true;

    @NotNull
    private boolean credentialsExpired;

    @NotNull
    private boolean expired;

    @NotNull
    private boolean locked;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "AccountRole",
            joinColumns = @JoinColumn(name = "accountId",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId",
                    referencedColumnName = "id"))
    private Set<Role> roles;

    public Account() {
        super();
    }

    /**
     * Create a new Account object with the supplied username and password values.
     *
     * @param username A String username value.
     * @param password A String clear text password value.
     */
    public Account(final String username, final String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Create a new Account object with the supplied username, password, and Set of Role objects.
     *
     * @param username A String username value.
     * @param password A String clear text password value.
     * @param roles A Set of Role objects.
     */
    public Account(final String username, final String password, final Set<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
