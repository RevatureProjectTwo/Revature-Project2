package com.Revature.ecommerce.project2WesPSamvelA.dao;

import java.util.List;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;
// import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

    @Query( value = "SELECT * FROM user_details WHERE user_username = ?1 AND user_password = ?2", nativeQuery = true)
    public UserEntity getUserByUsernameAndPassword(String userUserName,
                                             String userPassword);

}

