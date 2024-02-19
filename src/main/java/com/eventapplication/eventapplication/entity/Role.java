package com.eventapplication.eventapplication.entity;

import com.eventapplication.eventapplication.enums.RoleEnum;
import com.eventapplication.eventapplication.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "roles")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title" ,nullable = false)
    private String  title;

    @Column(name = "description" ,length = 3000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
