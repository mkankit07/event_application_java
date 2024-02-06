package com.eventapplication.eventapplication.utils;

import com.eventapplication.eventapplication.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    private UserSpecification(){

    }
    public static Specification<User> hasFirstName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("firstName"), name);
    }
    public static Specification<User> hasLastName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("lastName"), name);
    }
}
