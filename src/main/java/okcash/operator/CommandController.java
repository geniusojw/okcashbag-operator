package okcash.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {
	
	private static final String COMMAND_QUEUE = "command-queue";
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/{commandType}", method = RequestMethod.GET)
	public String command(@PathVariable final String commandType) {
		jmsTemplate.convertAndSend(COMMAND_QUEUE, commandType);
		return "success";
	}
}
