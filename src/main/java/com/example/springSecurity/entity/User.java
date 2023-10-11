package com.example.springSecurity.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private boolean enabled =false;
}