package no.tobias.firstspringboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PartsRepository {

    private ArrayList<Part> parts = new ArrayList<>();


    public ArrayList<Part> getParts() {
        return parts;
    }

    public PartsRepository() {
        parts.add(new Part("gear"));
        parts.add(new Part("cog"));
    }

    public void addParts(Part part) {
        parts.add(part);
    }

}
