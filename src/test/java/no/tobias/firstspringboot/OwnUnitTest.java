package no.tobias.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
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
}
