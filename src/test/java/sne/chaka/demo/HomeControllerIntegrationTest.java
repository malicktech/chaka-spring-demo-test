package sne.chaka.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void runAndInvokeHome() throws Exception {
		String url = "http://localhost:" + port + "/";
		String body = this.restTemplate.getForObject(url, String.class);
		assertThat(body.contains("Hello World"));
	}

	@Test
	public void runAndInvokeSecureHome() throws Exception {
		String url = "http://localhost:" + port + "/";
		String body = new TestRestTemplate("employee", "employee").getForObject(url, String.class);
		assertThat(body.contains("Hello World"));
	}

}
