package com.Springpro.Sprigpro.Repository;

import com.Springpro.Sprigpro.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    boolean existsByName(String name);
    Users findByName(String name);
}
