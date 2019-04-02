package com.example.TestMediaSoft.entities.personEntities;

import org.springframework.security.core.GrantedAuthority;

/**
 * This class describe allows roles for user.
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}