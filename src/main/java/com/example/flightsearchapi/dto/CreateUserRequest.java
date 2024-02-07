package com.example.flightsearchapi.dto;


import com.example.flightsearchapi.model.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
