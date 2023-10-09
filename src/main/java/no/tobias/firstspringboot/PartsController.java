package no.tobias.firstspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@Slf4j
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping()
    public ResponseEntity<List<Part>> getParts() {
        //var bigPart = BigPart.builder()
        //        .partName("heu")
        //        .partNumber(1)
        //        .numberOfChickens(2).
        //        build();

        return ResponseEntity.ok(partsService.getParts());
    }

    @PostMapping()
    public void addParts(@RequestBody Part part) {

        partsService.addPart(part);
    }

    @DeleteMapping("{name}")
    public void deletePart(@PathVariable String name) {

        partsService.deletePart(name);
    }

    @PutMapping("{name}")
    public void putPart(@RequestBody Part part, @PathVariable String name) {

        partsService.putPart(part, name);
    }
}
