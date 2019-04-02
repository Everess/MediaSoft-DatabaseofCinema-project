package com.example.TestMediaSoft.entities.personEntities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * User entity.
 */
@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of user.
     */
    private String username;

    /**
     * Password of user.
     */
    private String password;

    /**
     * Variable for activation account. At now default true.
     */
    private boolean active;

    /**
     * Email of user.
     * TODO: Make send mail for user email. At now not used variable.
     */
    private String email;

    /**
     * Activation code for user.
     * TODO: Make send mail with activation code for user email. At now not used variable.
     */
    private String activationCode;

    /**
     * Union with user role tables.
     */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    /**
     * User verification method on admin.
     * @return roles Role of user.
     */
    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    /**
     * TODO: Account duration.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * TODO: Account lock.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * TODO: Activated account.
     */
    @Override
    public boolean isEnabled() {
        return isActive();
    }

    /**
     * Method allows set username of user.
     * @param username Name of user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get list of roles.
     * @return getRoles() Roles list.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    /**
     * Method allows get user password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method allows set user password.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Activated account.
     * @return active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Method allows set activation of account.
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method allows get list of user roles.
     * @return roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Method allows set user role.
     * @param roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}