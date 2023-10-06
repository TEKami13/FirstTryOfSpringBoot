package no.tobias.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OwnUnitTest {

    @MockBean
    private PartsRepository partsRepository;

    @Autowired
    private PartsService partsService;

    @Test
    void shouldGetPartsFromService() {
        ArrayList<Part> partsList = new ArrayList<>(List.of(new Part("pogo")));
        when(partsRepository.getParts()).thenReturn(partsList);

        assertThat(partsService.getParts().size()).isEqualTo(1);
        assertThat(partsService.getParts().get(0).name()).isEqualTo("pogo");
    }

    @Test
    void shouldDeletePartFromService() {
        ArrayList<Part> partsList = new ArrayList<>(List.of(new Part("pogo"), new Part("screw")));
        when(partsRepository.getParts()).thenReturn(partsList);

        assertThat(partsService.getParts().size()).isEqualTo(2);
        assertThat(partsService.getParts().get(0).name()).isEqualTo("pogo");
        assertThat(partsService.getParts().get(1).name()).isEqualTo("screw");

        partsService.deletePart("pogo");

        assertThat(partsService.getParts().size()).isEqualTo(1);
        assertThat(partsService.getParts().get(0).name()).isEqualTo("screw");

    }
}
