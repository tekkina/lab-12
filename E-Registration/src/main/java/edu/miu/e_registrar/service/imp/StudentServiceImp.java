package edu.miu.e_registrar.service.imp;

import edu.miu.e_registrar.model.Student;
import edu.miu.e_registrar.repository.StudentRepository;
import edu.miu.e_registrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImp implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }
    @Override
    public Page<Student> getAllStudentsPaged(Integer pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.by(Sort.Direction.ASC,"firstName")));
    }
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudent(String str) {
        return studentRepository.findStudentByStudentIdOrFirstNameOrLastNameOrMiddleName(str);
    }
}
