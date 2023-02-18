package edu.miu.e_registrar.service.imp;

import edu.miu.e_registrar.model.Classroom;
import edu.miu.e_registrar.repository.ClassRoomRepository;
import edu.miu.e_registrar.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomImp implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Override
    public Classroom addNewClassRoom(Classroom newClassroom) {

        return classRoomRepository.save(newClassroom) ;
    }
}
