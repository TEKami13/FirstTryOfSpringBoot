package no.tobias.firstspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping()
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/parts")
    public List<Part> getParts() {
        return partsService.getParts();
    }
}
