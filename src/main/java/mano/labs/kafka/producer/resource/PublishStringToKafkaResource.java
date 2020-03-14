package mano.labs.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafkaManagement/v1")
public class PublishStringToKafkaResource {
	
	@Autowired KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "StringMessageKafkaExample";
	
	@GetMapping("/publishString/{msg}")
	public String post(@PathVariable("msg") final String message) {
		kafkaTemplate.send(TOPIC, "Hello "+message);
		System.out.println("Hello " + message);
		return "Hello "+message; 
	}

}
