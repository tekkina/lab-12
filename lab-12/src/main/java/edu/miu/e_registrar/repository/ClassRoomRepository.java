package edu.miu.e_registrar.repository;


import edu.miu.e_registrar.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends CrudRepository<Classroom,Integer> {
}
