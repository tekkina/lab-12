package edu.miu.e_registrar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "classrooms")

public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer classroomId;
   private String  buildingName;
    private String    roomNumber;
   @OneToMany(mappedBy = "primaryClassroom")
  //@JoinColumn(name ="primary_student_id",nullable = true)
   private List<Student>student;

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber;

    }
}

