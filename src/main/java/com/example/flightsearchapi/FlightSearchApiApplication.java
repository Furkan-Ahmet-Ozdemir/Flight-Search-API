package com.example.flightsearchapi;

import com.example.flightsearchapi.dto.CreateUserRequest;
import com.example.flightsearchapi.model.Role;
import com.example.flightsearchapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Set;


@SpringBootApplication
@EnableScheduling
public class FlightSearchApiApplication implements CommandLineRunner {

    private final UserService userService;

    public FlightSearchApiApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    private void createUsers() {
        CreateUserRequest user = CreateUserRequest.builder()
                .name("Furkan")
                .username("user")
                .password("user")
                .authorities(Set.of(Role.ROLE_USER))
                .build();
        userService.createUser(user);

        CreateUserRequest admin = CreateUserRequest.builder()
                .name("Mehmet")
                .username("admin")
                .password("admin")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();
        userService.createUser(admin);
    }

}
