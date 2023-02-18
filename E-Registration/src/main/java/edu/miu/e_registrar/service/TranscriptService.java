package edu.miu.e_registrar.service;

import edu.miu.e_registrar.model.Transcript;

public interface TranscriptService {
    Transcript addNewTranscript(Transcript newTranscript);
    Transcript getTranscriptById(Integer transcriptId);
}
