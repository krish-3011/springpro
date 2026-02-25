package com.Springpro.Sprigpro.Service.impl;


import com.Springpro.Sprigpro.Entity.Student;
import com.Springpro.Sprigpro.Exception.StudentNotFoundException;
import com.Springpro.Sprigpro.Repository.StudentRepo;
import com.Springpro.Sprigpro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Page<Student> fetchAllStudent(Pageable pageable){
        return studentRepo.findAll(pageable );
    }

    public  Student getStudentById(Integer id){
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Studnet with id " + id + " not found"));

    }

    @Override
    public Student saveDetails(Student student){

        if(student.getId()== null && studentRepo.existsById(student.getId())){
            throw new StudentNotFoundException("Student id: "+ student.getId() +" id either null or already exist");
        }
        else
            return studentRepo.save(student);

    }
    @Override
    public  boolean deleteStudent(Integer id){

        if(!studentRepo.existsById(id)){
            throw new StudentNotFoundException("Studnet with id " + id + " not found");
        }
        else {
            studentRepo.deleteById(id);
            return true;
        }

    }


    @Override
    public Student updateDetails(Student student){
        Student updateStudent = studentRepo.findById(student.getId()).orElse(null);
        System.out.println(updateStudent);
        if(updateStudent != null){
            updateStudent.setMark(student.getMark());
            updateStudent.setName(student.getName());
            studentRepo.save(updateStudent);
            return  updateStudent;
        }
        else
            throw new StudentNotFoundException("Studnet with id   not found");

    }
    @Override
    public Student updatePatchDetails(Integer id, Map<String,Object> updates){
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("no student exist with give id"));
        System.out.println("hellooo i am updae");
        System.out.println(updates);
        updates.forEach((key,value) -> {
            switch (key){
                case "name" -> existingStudent.setName(value.toString());
                case "mark" -> {
                    System.out.println("helloooo" + value);
                    Integer markValue = ((Number) value).intValue();
                    existingStudent.setMark(markValue);
                }


            }
        });
        return  studentRepo.save(existingStudent);
    }
}
