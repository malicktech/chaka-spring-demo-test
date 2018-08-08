package sne.chaka.demo.config.actuator;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Custom indicateur
 * 
 * @author citizendiop
 *
 */
@Component
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		// perform some specific health check
		boolean result = check();
		if (!result)
			return Health.down().withDetail("Random().nextBoolean()", result).build();
		else
			return Health.up().build();
	}

	public boolean check() {
		// Our logic to check health
		return new Random().nextBoolean();
	}
}
