package sne.chaka.demo.config.actuator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Endpoint(id = "features")
public class CustomEndpoint {

	private Map<String, Feature> features = new ConcurrentHashMap<>();

	@ReadOperation
	public Map<String, Feature> features() {
		return features;
	}

	@ReadOperation
	public Feature feature(@Selector String name) {
		return features.get(name);
	}

	@WriteOperation
	public void configureFeature(@Selector String name, Feature feature) {
		features.put(name, feature);
	}

	@DeleteOperation
	public void deleteFeature(@Selector String name) {
		features.remove(name);
	}

	@Getter @Setter
	public static class Feature {
		private Boolean enabled;

	}

}
