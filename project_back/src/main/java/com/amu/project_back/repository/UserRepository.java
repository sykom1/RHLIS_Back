package com.amu.project_back.repository;

import com.amu.project_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


    User findByToken(String token);



    boolean existsByUsername(String username);


    @Transactional
    void deleteByUsername(String username);

}