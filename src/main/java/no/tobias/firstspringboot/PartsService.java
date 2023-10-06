package no.tobias.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    private final PartsRepository partsRepository;

    @Autowired
    public PartsService(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public List<Part> getParts() {

        return partsRepository.getParts();
    }

    public void addPart(Part part) {

        partsRepository.addParts(part);
    }

    public void deletePart(String name) {

        partsRepository.deleteParts(new Part(name));
    }

    public void putPart(Part part, String name) {

        partsRepository.putParts(part, new Part(name));
    }
}
