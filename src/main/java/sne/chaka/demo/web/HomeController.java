package sne.chaka.demo.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Secured("ROLE_EMPLOYEE")
	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}
}
