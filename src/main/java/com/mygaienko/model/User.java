package com.mygaienko.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

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

    /*public User(User user, List<UserAuthority> authorities) {
        this.id = user.id;
        this.email = user.email;
        this.firstName = user.firstName;
        this.surname = user.surname;
        this.contactNumber = user.contactNumber;
        this.address = user.address;
        this.password = user.password;
        this.authorities = authorities;
    }*/

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

}
