package edu.miu.e_registrar.controller;


import edu.miu.e_registrar.model.Classroom;
import edu.miu.e_registrar.model.Student;
import edu.miu.e_registrar.model.Transcript;
import edu.miu.e_registrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/","/info","/get/info"})
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(value = "/list")
    public ModelAndView displayStudent(){
        var modelAndView = new ModelAndView();
        var student =studentService.getAllStudents();
        modelAndView.addObject("students",student);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }
    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student(null,null,null,null,null, null,null,new Transcript(),new Classroom()));
        return "secured/student/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }

        studentService.addNewStudent(student);
        studentService.addNewStudent(student);
        return "redirect:/get/info/list";
    }
    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {

        var student=studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/get/info/list";
    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }

        studentService.updateStudent(student);
        return "redirect:/get/info/list";
    }
    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/get/info/list";
    }

    @GetMapping(value = "/showsearch")
    public String showSearch(){
        return "secured/student/searchForm";
    }

    @GetMapping(value = "/search")
    public ModelAndView studentSearch( String searchString){
        var modelAndView = new ModelAndView();
        var students =studentService.searchStudent(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/student/search");
        return modelAndView;
    }
}
