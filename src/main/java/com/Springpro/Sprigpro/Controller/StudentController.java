package com.Springpro.Sprigpro.Controller;


import com.Springpro.Sprigpro.Entity.Student;
import com.Springpro.Sprigpro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> postDetails(@RequestBody Student student){
        System.out.println(student.getName());
        System.out.println(student.getMark());
        return  ResponseEntity.ok(studentService.saveDetails(student));
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return  ResponseEntity.ok(studentService.fetchAllStudent(pageable));
    }



    @GetMapping("student/{id}")
    public  ResponseEntity<Student> findStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


    @DeleteMapping("/del/{delId}")
    public ResponseEntity<Void> delStudent(@PathVariable Integer delId){
        studentService.deleteStudent(delId);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public  ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return  ResponseEntity.ok(studentService.updateDetails(student));
    }

    @PatchMapping("/patchUpdate/{id}")
    public  ResponseEntity<Student> updatePatchStudent (@PathVariable Integer id,@RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePatchDetails(id,updates));
    }

}
