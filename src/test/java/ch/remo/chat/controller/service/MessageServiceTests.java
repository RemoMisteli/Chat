package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.remo.chat.controller.entity.MessageEntity;
import ch.remo.chat.controller.model.Message;

public class MessageServiceTests {

	private static final String HALLO_MSG = "Hallo";
	MessageService messageService;
	MessageEntity messageEntityFull;
	MessageEntity mesageEntityContentIsNull;
	MessageEntity measageEntityIdIsNull;
	MessageEntity measageEntityisNull;
	MessageEntity messageNull;

	Message fullMessage;
	Message idIsNullMessage;
	Message messageIsNullMessage;
	List<MessageEntity> listFull;

	List<MessageEntity> listMessageEntityContentIsNull;
	List<MessageEntity> listMeasageEntityIdIsNull;

	List<MessageEntity> listMeasageEntityisNull;
	List<MessageEntity> listWithNullMessages;

	@Before
	public void init() {
		messageService = new MessageService();
		messageEntityFull = new MessageEntity();
		messageEntityFull.setId(1L);
		messageEntityFull.setContent(HALLO_MSG);

		mesageEntityContentIsNull = new MessageEntity();
		mesageEntityContentIsNull.setId(2L);
		mesageEntityContentIsNull.setContent(null);

		measageEntityIdIsNull = new MessageEntity();
		measageEntityIdIsNull.setId(null);
		measageEntityIdIsNull.setContent(HALLO_MSG);

		measageEntityisNull = new MessageEntity();
		measageEntityisNull.setId(null);
		measageEntityisNull.setContent(null);
		messageNull = null;

		fullMessage = new Message();
		fullMessage.setId(3L);
		fullMessage.setContent(HALLO_MSG);

		idIsNullMessage = new Message();
		idIsNullMessage.setId(null);
		idIsNullMessage.setContent(HALLO_MSG);

		messageIsNullMessage = new Message();
		messageIsNullMessage.setId(4L);
		messageIsNullMessage.setContent(null);

		listFull = new ArrayList<>();
		listFull.add(messageEntityFull);
		listFull.add(messageEntityFull);

		listMessageEntityContentIsNull = new ArrayList<>();
		listMessageEntityContentIsNull.add(mesageEntityContentIsNull);
		listMessageEntityContentIsNull.add(mesageEntityContentIsNull);

		listMeasageEntityIdIsNull = new ArrayList<>();
		listMeasageEntityIdIsNull.add(measageEntityIdIsNull);
		listMeasageEntityIdIsNull.add(measageEntityIdIsNull);

	}

	@Test
	public void toModel_testFullEntity() {
		Message message = messageService.toModel(messageEntityFull);
		Assert.assertTrue("Is id set?", message.getId() == 1L);
		Assert.assertTrue("Is message the right test message?", message.getContent().equals(HALLO_MSG));
	}

	@Test
	public void toModel_testMessageGetMessageNull() {
		Message message = messageService.toModel(mesageEntityContentIsNull);
		Assert.assertTrue("Is getContent Null", message == null);
	}

	@Test
	public void toModel_testIdIsNull() {
		Message message = messageService.toModel(measageEntityIdIsNull);
		Assert.assertTrue("Is id Null", message == null);
	}

	@Test
	public void toModel_testIsMessageNull() {
		Message message = messageService.toModel(measageEntityisNull);
		Assert.assertTrue("Is message Null", message == null);

	}

	@Test
	public void toModel_testIsMessageObjectNull() {
		Message message = messageService.toModel(messageNull);
		Assert.assertTrue("Is message Null", message == null);
	}

	@Test
	public void toEntity_Test() {
		MessageEntity entity = messageService.toEntity(fullMessage);
		Assert.assertTrue("is id Correct", entity.getId() == 3);
		Assert.assertTrue("is message Correct", entity.getContent().equals(HALLO_MSG));

	}

	@Test
	public void toEntity_idIsNull() {
		MessageEntity entity = messageService.toEntity(idIsNullMessage);
		Assert.assertTrue("entity is null when id is null ", entity == null);

	}

	@Test
	public void toEntity_messageIsNull() {
		MessageEntity entity = messageService.toEntity(messageIsNullMessage);
		Assert.assertTrue("entity is null when message is null ", entity == null);
	}

	@Test
	public void toModel_ListWithWorkingMessages() {
		List<Message> messages = messageService.toModel(listFull);
		Message message = messages.get(0);
		Assert.assertTrue("Is list ToModel working", messages != null);
		Assert.assertTrue("Is list ToModel working and has two entries", messages.size() == 2);
		Assert.assertTrue("Is id set?", message.getId() == 1L);
		Assert.assertTrue("Is message the right test message?", message.getContent().equals(HALLO_MSG));
	}

	@Test
	public void toModel_ListWithContentNull() {
		List<Message> messages = messageService.toModel(listMessageEntityContentIsNull);
		Message message = messages.get(0);
		Assert.assertTrue("list is emty", message == null);

	}

	@Test
	public void toModel_ListWithIdNull() {
		List<Message> messages = messageService.toModel(listMeasageEntityIdIsNull);
		Message message = messages.get(0);

		Assert.assertTrue("list is emty ", message == null);

	}

}
