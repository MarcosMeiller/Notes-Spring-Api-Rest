package com.restfull.RESTfull.repository;

import com.restfull.RESTfull.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("manageUser")
public interface ManageUser extends JpaRepository<User, Serializable> {
    public abstract User findByUsername(String username);
}
