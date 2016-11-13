package com.mygaienko.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by enda1n on 12.11.2016.
 */
public enum UserAuthority implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_CLIENT,
    ROLE_MASTER;

    @Override
    public String getAuthority() {
        return name();
    }

}
