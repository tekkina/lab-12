package edu.miu.e_registrar.repository;



import edu.miu.e_registrar.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript,Integer> {
}
