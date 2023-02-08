package edu.miu.e_registrar.service;


import edu.miu.e_registrar.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {
   Student addNewStudent(Student newStudent);
   Student getStudentById(Integer studentId);
   Student updateStudent(Student student);
   void deleteStudentById(Integer studentId);

   Page<Student> getAllStudentsPaged(Integer pageNo);
   Iterable<Student> getAllStudents();

    List<Student> searchStudent(String searchString);
}
