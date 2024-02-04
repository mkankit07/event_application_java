package com.eventapplication.eventapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Table(name = "user_roles")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id",nullable = false,referencedColumnName = "id" ,foreignKey = @ForeignKey(name = "fk_users_roles_users_id"))
    private User users;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id",nullable = false,referencedColumnName = "id" ,foreignKey = @ForeignKey(name = "fk_users_roles_roles_id"))
    private Role roles;
}
