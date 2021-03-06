package ch.remo.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.remo.chat.controller.model.Message;
import ch.remo.chat.controller.service.MessageService;
import ch.remo.chat.exception.MessageNotValidException;
import io.swagger.annotations.ApiOperation;


@RestController(value = "chat/messages")
@RequestMapping("chat/messages")
public class MessageController {
	
	@Autowired 
	MessageService messageService;
	
	@ApiOperation(value = "", response = Message.class,responseContainer="List", tags="Message API")
	@GetMapping(path = "")
	public List<Message> getContent() {
		return messageService.getAll();
	}
	
	@ApiOperation(value = "chat/messages", response = Message.class, tags="Message API")
	@PostMapping(path = "")
	public Message insertContent(@RequestBody Message message) {
		return messageService.insertContent(message);
	}
	
	@ApiOperation(value = "chat/messages/{id}", response = Message.class, tags="Message API")
	@PutMapping(path = "/{id}")
	public Message updateContent(@RequestBody Message message,@PathVariable("id") Long messageId) throws MessageNotValidException {
		return messageService.updateContent(messageId,message);
	}
	
	@ApiOperation(value = "chat/messages/{id}", tags="Message API")
	@DeleteMapping(path ="/{id}")
	public void deleteContent(@PathVariable("id") Long messageId) throws MessageNotValidException {
		messageService.deleteContent(messageId);
		
	}
}
