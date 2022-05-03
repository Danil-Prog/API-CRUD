package com.lesson.api.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


public enum Role implements GrantedAuthority {


    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
