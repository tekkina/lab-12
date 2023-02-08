package edu.miu.e_registrar.service.imp;

import edu.miu.e_registrar.model.Transcript;
import edu.miu.e_registrar.repository.TranscriptRepository;
import edu.miu.e_registrar.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImp implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Override
    public Transcript addNewTranscript(Transcript newTranscript) {

        return transcriptRepository.save(newTranscript);
    }

    @Override
    public Transcript getTranscriptById(Integer transcriptId) {
        return transcriptRepository.findById(transcriptId).orElse(null);
    }
}
