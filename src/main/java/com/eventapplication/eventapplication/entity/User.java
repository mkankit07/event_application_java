package com.eventapplication.eventapplication.entity;

import com.eventapplication.eventapplication.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "bio", length = 3000 ,nullable = true)
    private String bio;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToMany(mappedBy = "users")
    private Set<UserRole> userRoles;


}
