package com.Springpro.Sprigpro.Service;

import com.Springpro.Sprigpro.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface StudentService {
    Page<Student> fetchAllStudent(Pageable pageable);
    Student getStudentById(Integer id);
    Student saveDetails(Student student);
    boolean deleteStudent(Integer id);
    Student updateDetails(Student student);
    Student updatePatchDetails(Integer id, Map<String, Object> updates);
}
