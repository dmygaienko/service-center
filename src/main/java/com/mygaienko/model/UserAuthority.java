package com.mygaienko.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by enda1n on 12.11.2016.
 */
public enum UserAuthority implements GrantedAuthority {

    ADMINISTRATOR,
    CLIENT,
    MASTER;

    @Override
    public String getAuthority() {
        return name();
    }

}
