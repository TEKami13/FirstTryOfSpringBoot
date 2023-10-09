package no.tobias.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private PartsController partsController;

	@Test
	void contextLoads() {
		assertThat(partsController).isNotNull();
	}

}
