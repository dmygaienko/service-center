package com.mygaienko.model.dto;

import com.mygaienko.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by enda1n on 20.11.2016.
 */
@Data
@NoArgsConstructor
public class UserInfo {

    private boolean authenticated = false;
    private long id;
    private String email;
    private String username;
    private String surname;

    private Collection<? extends GrantedAuthority> authorities;

    public UserInfo(User user) {
        authenticated = true;
        id = user.getId();
        email = user.getEmail();
        username = user.getUsername();
        surname = user.getSurname();
        authorities = user.getAuthorities();
    }

    public UserInfo(Authentication authentication) {
        if (authentication != null) {
            authenticated = authentication.isAuthenticated();
            username = authentication.getName();
            authorities = authentication.getAuthorities();
        }
    }

}
