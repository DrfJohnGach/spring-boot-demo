package com.drfjohngach.springbootmongo.service;

import com.drfjohngach.springbootmongo.repository.StudentRepository;
import com.drfjohngach.springbootmongo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
