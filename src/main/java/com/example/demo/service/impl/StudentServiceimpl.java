package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService{
    @Autowired StudentRepository student;
    //save()
    //findAll()
    //findById()
    //existsById()
    //deleteById()
    
    @Override
     public StudentEntity postData(StudentEntity stu){
        return student.save(stu);
     }
}