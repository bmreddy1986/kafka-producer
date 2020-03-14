package mano.labs.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mano.labs.kafka.producer.models.User;

@RestController
@RequestMapping("kafkaManagement/v1")
public class PublishJsonToKafkaResource {
	
	@Autowired KafkaTemplate<String, User> kafkaTemplate;
	private static final String TOPIC = "JsonMessageKafkaExample";
	
	@GetMapping("/publishJson/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemplate.send(TOPIC, new User(name, "amdocs.com", "IT"));
		System.out.println("Published Json Msg: " + new User(name, "amdocs.com", "IT"));
		return "Message published"; 
	}
	
}
