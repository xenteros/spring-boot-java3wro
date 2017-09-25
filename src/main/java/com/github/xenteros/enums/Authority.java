package com.github.xenteros.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by agurgul on 25.09.2017.
 */
public enum Authority implements GrantedAuthority{
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
