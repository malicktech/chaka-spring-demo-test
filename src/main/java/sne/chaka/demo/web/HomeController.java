package sne.chaka.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sne.chaka.demo.GreetingService;
import sne.chaka.demo.config.HelloProperties;

@RestController
public class HomeController {
	private final GreetingService service;

	public HomeController(GreetingService service) {
		this.service = service;
	}

	@GetMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}

	@Autowired
	private HelloProperties helloProperties;

	@Secured("ROLE_EMPLOYEE")
	@GetMapping("/")
	public String hello() {
		return helloProperties.getPrefix() + " " + helloProperties.getTarget();
	}
}
