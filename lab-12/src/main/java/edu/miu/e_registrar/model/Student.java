package edu.miu.e_registrar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NotBlank(message = "student number is required")
    @Column(name = "student_Number", nullable = false)
    private String studentNumber;
    @NotBlank(message = "first is required")
    @Column(name = "first_Name", nullable = false)
    private  String firstName;
    @Column(name = "middle_Name", nullable = true)
    private  String middleName;
    @NotBlank(message = "last name  cannot be blank or empty or null")
    @Column(name = "last_Name", nullable = false)
    private  String lastName;
    @Column(name = "cgpa", nullable = true)
    private Double cgp;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Transcript_Id", nullable = true)
    private  Transcript transcripts;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinTable(name = "students_classRoom",
            joinColumns = {@JoinColumn(name = "student_Id",referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "classroom_Id", referencedColumnName = "classroomId")}
    )
    private  Classroom primaryClassroom;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgp=" + cgp +
                ", dateOfEnrollment=" + dateOfEnrollment +
                '}';
    }
}
