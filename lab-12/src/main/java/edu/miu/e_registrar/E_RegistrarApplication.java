package edu.miu.e_registrar;


import edu.miu.e_registrar.model.Classroom;
import edu.miu.e_registrar.model.Student;
import edu.miu.e_registrar.model.Transcript;
import edu.miu.e_registrar.service.ClassRoomService;
import edu.miu.e_registrar.service.StudentService;
import edu.miu.e_registrar.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;

@SpringBootApplication
public class E_RegistrarApplication{// implements CommandLineRunner {

//    private StudentService studentService;
//
//    private TranscriptService transcriptService;
//
//    private ClassRoomService classRoomService;

//    @Autowired
//    public void E_RegistrarApplication(StudentService studentService, TranscriptService transcriptService, ClassRoomService classRoomService){
//        this.classRoomService = classRoomService;
//        this.studentService = studentService;
//        this.transcriptService = transcriptService;
//    }

    public static void main(String[] args) {

        SpringApplication.run(E_RegistrarApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Hello spring boot, Student Management app started......");
//        //creating student
//
//        var student1 = new Student(null,"1111", "Sillo","Green", "David",3.2,
//                LocalDate.of(2023,1,24),null,null);
//        var saveStudent1=addNewStudent(student1);
//        System.out.println(saveStudent1);
//        var student2=new Student(null,"2222", "Alexander",
//                "Hamilton", "Samson",4.0,
//                LocalDate.of(2019,5,24),null,null);
//        var saveStudent2=addNewStudent(student2);
//        System.out.println(saveStudent2);
//
//        // create new Transcript
//        var transcript1= new Transcript(null, "BS Computer Science",null);
//        var saveTranscript= addNewTranscript(transcript1);
//        System.out.println(saveTranscript);
//
//        //create new classroom
//        var classroom1= new Classroom(null,"McLaughlin building", "M105",null);
//        var saveClassroom= addNewClassRoom(classroom1);
//        System.out.println(saveClassroom);
//
//
//
//        // get all
//
//        System.out.println("..........all students ............... ");
//        var studentsAll = studentService.getAllStudents();
//        for(Student students:studentsAll){
//            System.out.println(students);
//        }
//
//        System.out.println("student management app completed");
//        System.out.println("*********************************************************************************************");
//
//    }
//
//
//    private Student addNewStudent(Student student){
//        return studentService.addNewStudent(student);
//    }
//    Student saveStudent(Student newStudent){
//        return studentService.addNewStudent(newStudent);
//
//
//    }
//    Transcript addNewTranscript(Transcript newTranscript){
//
//        return transcriptService.addNewTranscript(newTranscript);
//    }
//    Classroom addNewClassRoom(Classroom newClassroom){
//
//        return  classRoomService.addNewClassRoom(newClassroom);
//    }
}

