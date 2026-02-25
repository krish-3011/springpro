package com.Springpro.Sprigpro.Repository;

import com.Springpro.Sprigpro.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {


}
