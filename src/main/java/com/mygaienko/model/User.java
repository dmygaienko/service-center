package com.mygaienko.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/*
GrantedAuthorities for the roles a user belongs to and the operations
a role can perform. The GrantedAuthorities for the roles have the prefix ROLE_ and the
operations have the prefix OP_. An example for operation authorities could be
OP_DELETE_ACCOUNT, OP_CREATE_USER, OP_RUN_BATCH_JOBetc. Roles can be ROLE_ADMIN,
        ROLE_USER etc.
*/

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "user")
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String firstName;

    private String surname;

    private String contactNumber;

    private String address;

    private String password;

    @ElementCollection(targetClass = UserAuthority.class, fetch = FetchType.EAGER)
   /* @CollectionTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id")
    )*/
    @Enumerated(EnumType.STRING)
    private List<UserAuthority> authorities;

    @Override
    public List<UserAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String name() {
        return firstName + " " + surname;
    }
}
