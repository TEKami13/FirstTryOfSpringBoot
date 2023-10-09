package no.tobias.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class PartsControllerUnitTest {

    @MockBean
    private PartsService partsService;

    @Autowired
    private PartsController partsController;

    @Test
    void shouldReturnResult() {
        ArrayList<Part> partsList = new ArrayList<>(List.of(new Part("pogo")));
        when(partsService.getParts()).thenReturn(partsList);

        assertThat(partsController.getParts().getBody().get(0).name()).isEqualTo("pogo");
    }
}
