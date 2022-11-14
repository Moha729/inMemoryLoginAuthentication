package com.mo.inmemoryloginauthentication;

import com.mo.inmemoryloginauthentication.model.Post;
import com.mo.inmemoryloginauthentication.model.User;
import com.mo.inmemoryloginauthentication.repo.PostRepo;
import com.mo.inmemoryloginauthentication.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class InMemoryLoginAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InMemoryLoginAuthenticationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepo posts, UserRepo users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User("user", encoder.encode("${MO_PASS}"),"ROLE_USER"));
            users.save(new User("admin",encoder.encode("${MO_PASS}"),"ROLE_USER,ROLE_ADMIN"));
            posts.save( new Post("Hello Mo", "Mo slug", "Welcome to my blog!", "Mo Stacks"));
        };

    }

}
