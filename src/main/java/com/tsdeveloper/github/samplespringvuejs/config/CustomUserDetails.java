package com.tsdeveloper.github.samplespringvuejs.config;

import com.tsdeveloper.github.samplespringvuejs.entities.Role;
import com.tsdeveloper.github.samplespringvuejs.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;

    public CustomUserDetails(User user) {
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.authorities = translate(user.getRoles());

    }

    public Collection<? extends GrantedAuthority> translate(List<Role> roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            String name  = role.getName().toUpperCase();
            if(!name.startsWith("ROLE_"))
                name = "ROLE_" + name;

            authorities.add(new SimpleGrantedAuthority(name));
        }

        return  authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
