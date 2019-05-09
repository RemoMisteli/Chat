package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ch.remo.chat.controller.entity.MessageEntity;
import ch.remo.chat.controller.entity.UserEntity;
import ch.remo.chat.controller.model.User;

//@SpringApplicationConfiguration(classes = ChatApplication.class)
@WebAppConfiguration
@SpringBootTest
@EnableConfigurationProperties
@RunWith(SpringRunner.class)
public class UserServiceTests {

	// UserService userService;
	UserEntity fullEntity;
	UserEntity fullEntityNoRecivedMessage;
	UserEntity fullEntityNoSendedMessage;
	UserEntity EntityWithNoSendedMesage;
	UserEntity EntityWithNoRecivedMesage;
	UserEntity idIsNull;
	UserEntity userIsNull;
	UserEntity passwordIsNull;

	User fulleUser;
	User idIsNullUser;
	User userIsNullUser;
	User passwordIsNullUser;
	
	List<UserEntity> listFullUserEntity;
	List<UserEntity> listNoIdEntity;
	List<UserEntity> listNoContentEntity;
	List<UserEntity> listNoSendedMessageEntity;
	List<UserEntity> listNoRecivedMessageEntity;
	List<UserEntity> listNoPasswordEntity;
	List<UserEntity> listNoUserEntity;
	
	List<MessageEntity> listFull;
	List<MessageEntity> listWithRecivedMessages;
	List<MessageEntity> listWithSendedMessages;

	MessageEntity sendetMessages;
	MessageEntity receivedMessages;
	MessageEntity messages;

	@Autowired
	
	UserService userService;

	@Before
	public void init() {

		
		
		
		fullEntity = new UserEntity();
		fullEntity.setId(1L);
		fullEntity.setUser("user1");
		fullEntity.setPassword("password");
		
		fullEntityNoSendedMessage = new UserEntity();
		fullEntityNoSendedMessage.setId(1L);
		fullEntityNoSendedMessage.setUser("user1");
		fullEntityNoSendedMessage.setPassword("password");
		
		
		fullEntityNoRecivedMessage = new UserEntity();
		fullEntityNoRecivedMessage.setId(1L);
		fullEntityNoRecivedMessage.setUser("user1");
		fullEntityNoRecivedMessage.setPassword("password");
		
		idIsNull = new UserEntity();
		idIsNull.setId(null);
		idIsNull.setUser("user1");
		idIsNull.setPassword("password");

		EntityWithNoSendedMesage = new UserEntity();
		EntityWithNoSendedMesage.setId(2L);
		EntityWithNoSendedMesage.setUser("user1");
		EntityWithNoSendedMesage.setPassword("password");

		EntityWithNoRecivedMesage = new UserEntity();
		EntityWithNoRecivedMesage.setId(3L);
		EntityWithNoRecivedMesage.setUser("user1");
		EntityWithNoRecivedMesage.setPassword("password");

		messages = new MessageEntity();
		messages.setId(1L);
		messages.setContent("test");

		receivedMessages = new MessageEntity();
		receivedMessages.setId(2L);
		receivedMessages.setContent("test");

		sendetMessages = new MessageEntity();
		sendetMessages.setId(3L);
		sendetMessages.setContent("test");

		listFull = new ArrayList<>();
		listFull.add(messages);
		listFull.add(messages);
		fullEntity.setSentMessages(listFull);
		fullEntity.setReceivedMessages(listFull);

		listWithRecivedMessages = new ArrayList<>();
		listWithRecivedMessages.add(receivedMessages);
		listWithRecivedMessages.add(receivedMessages);
		EntityWithNoSendedMesage.setReceivedMessages(listWithRecivedMessages);

		listWithSendedMessages = new ArrayList<>();
		listWithSendedMessages.add(sendetMessages);
		listWithSendedMessages.add(sendetMessages);
		EntityWithNoRecivedMesage.setSentMessages(listWithSendedMessages);

		fulleUser = new User();
		fulleUser.setId(4L);
		fulleUser.setUser("user1");
		fulleUser.setPassword("password");

		

		userIsNull = new UserEntity();
		userIsNull.setId(2L);
		userIsNull.setUser(null);
		userIsNull.setPassword("password");

		passwordIsNull = new UserEntity();
		passwordIsNull.setId(3L);
		passwordIsNull.setUser("user1");
		passwordIsNull.setPassword(null);

		idIsNullUser = new User();
		idIsNullUser.setId(null);
		idIsNullUser.setUser("user1");
		idIsNullUser.setPassword("password");

		userIsNullUser = new User();
		userIsNullUser.setId(5L);
		userIsNullUser.setUser(null);	userIsNullUser.setPassword("password");

		passwordIsNullUser = new User();
		passwordIsNullUser.setId(6L);
		passwordIsNullUser.setUser("user1");
		passwordIsNullUser.setPassword(null);
		
		idIsNull.setSentMessages(listFull);
		idIsNull.setReceivedMessages(listFull);
		
		userIsNull.setSentMessages(listFull);
		userIsNull.setReceivedMessages(listFull);
		
		passwordIsNull.setSentMessages(listFull);
		passwordIsNull.setReceivedMessages(listFull);
		
		fullEntityNoSendedMessage.setReceivedMessages(listFull);
		
		fullEntityNoRecivedMessage.setSentMessages(listFull);
		
		listFullUserEntity= new ArrayList<>();
		listFullUserEntity.add(fullEntity);
		listFullUserEntity.add(fullEntity);
		
		listNoIdEntity= new ArrayList<>();
		listNoIdEntity.add(idIsNull);
		listNoIdEntity.add(idIsNull);
		
		
		
		listNoUserEntity= new ArrayList<>();
		listNoUserEntity.add(userIsNull);
		listNoUserEntity.add(userIsNull);
		
		
		
		listNoPasswordEntity= new ArrayList<>();
		listNoPasswordEntity.add(passwordIsNull);
		listNoPasswordEntity.add(passwordIsNull);
		
		listNoSendedMessageEntity= new ArrayList<>();
		listNoSendedMessageEntity.add(fullEntityNoSendedMessage);
		listNoSendedMessageEntity.add(fullEntityNoSendedMessage);
		
		listNoRecivedMessageEntity= new ArrayList<>();
		listNoRecivedMessageEntity.add(fullEntityNoRecivedMessage);
		listNoRecivedMessageEntity.add(fullEntityNoSendedMessage);
		
		
		
	}

	@Test
	public void toModel_TestFullValues() {
		User model = userService.toModel(fullEntity);
		Assert.assertTrue("is id Correct", model.getId() == 1L);
		Assert.assertTrue("is username Correct", model.getUser().equals("user1"));
		Assert.assertTrue("is Password Correct", model.getPassword().equals("password"));
		Assert.assertTrue("Sended Message have the rigt Id", model.getSentMessages().get(0).getId() == 1L);
		Assert.assertTrue("Sended Mesages have te correct value",
				model.getSentMessages().get(0).getContent().equals("test"));
		Assert.assertTrue("Received Messages have the rigt Id", model.getReceivedMessages().get(0).getId() == 1L);
		Assert.assertTrue("Received Messages have te correct value",
				model.getReceivedMessages().get(0).getContent().equals("test"));
	}

	@Test
	public void toModel_withNoSendedMessage() {
		User model = userService.toModel(EntityWithNoSendedMesage);
		Assert.assertTrue("is id Correct", model.getId() == 2L);
		Assert.assertTrue("is username Correct", model.getUser().equals("user1"));
		Assert.assertTrue("is Password Correct", model.getPassword().equals("password"));
		Assert.assertTrue("no Sended Messages", model.getSentMessages().isEmpty());
		Assert.assertTrue("Received Messages have the rigt Id", model.getReceivedMessages().get(0).getId() == 2L);
		Assert.assertTrue("Received Messages have te correct value",
				model.getReceivedMessages().get(0).getContent().equals("test"));
	}

	@Test
	public void toModel_withNoRecivedMessage() {
		User model = userService.toModel(EntityWithNoRecivedMesage);
		Assert.assertTrue("is id Correct", model.getId() == 3L);
		Assert.assertTrue("is username Correct", model.getUser().equals("user1"));
		Assert.assertTrue("is Password Correct", model.getPassword().equals("password"));
		Assert.assertTrue("Received Messages have the rigt Id", model.getSentMessages().get(0).getId() == 3L);
		Assert.assertTrue("Received Messages have te correct value",
				model.getSentMessages().get(0).getContent().equals("test"));
		Assert.assertTrue("no Sended Messages", model.getReceivedMessages().isEmpty());
	}

	@Test
	public void toModel_idIsNull() {
		User model = userService.toModel(idIsNull);
		Assert.assertTrue("model is null wen id is null", model == null);

	}

	@Test
	public void toModel_userIsNull() {
		User model = userService.toModel(userIsNull);
		Assert.assertTrue("model is null wen id is null", model == null);

	}

	@Test
	public void toModel_passwordIsNull() {
		User model = userService.toModel(passwordIsNull);
		Assert.assertTrue("model is null wen id is null", model == null);

	}

	@Test
	public void toEntity_Test() {
		UserEntity entity = userService.toEntity(fulleUser);
		Assert.assertTrue("is id Correct", entity.getId() == 4L);
		Assert.assertTrue("is username Correct", entity.getUser().equals("user1"));

	}

	@Test
	public void toEntity_idIsNull() {
		UserEntity entity = userService.toEntity(idIsNullUser);
		Assert.assertTrue("enteti is null wen id is null", entity == null);

	}

	@Test
	public void toEntity_userIsNull() {
		UserEntity entity = userService.toEntity(userIsNullUser);
		Assert.assertTrue("enteti is null wen user is null", entity == null);

	}

	@Test
	public void toEntity_passwordIsNull() {
		UserEntity entity = userService.toEntity(passwordIsNullUser);
		Assert.assertTrue("enteti is null wen password is null", entity == null);

	}

	@Test
	public void toModel_ListWithFullEntity() {
		List<User> models = userService.toModel(listFullUserEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is UserId correct", user.getId() == 1L);
	    Assert.assertTrue("is Username Correct", user.getUser().equals("user1"));
	    Assert.assertTrue("is password Correct", user.getPassword().equals("password"));
	    Assert.assertTrue("Is sended Message id Correct", user.getSentMessages().get(0).getId()==1L);
	    Assert.assertTrue("Is sended Message content Correct", user.getSentMessages().get(0).getContent().equals("test"));
	    Assert.assertTrue("Is recived Message id Correct", user.getReceivedMessages().get(0).getId()==1L);
	    Assert.assertTrue("Is recived Message content Correct", user.getReceivedMessages().get(0).getContent().equals("test"));
	
	}//TODO
	@Test
	public void toModel_ListWithNoId() {
		List<User> models = userService.toModel(listNoIdEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is no user", user== null);
	    
	
	}
	@Test
	
	public void toModel_ListWithNoUser() {
		List<User> models = userService.toModel(listNoUserEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is no user", user== null);
	}
	public void toModel_ListWithNoPassword() {
		List<User> models = userService.toModel(listNoPasswordEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is no user", user== null);
	    
	}@Test
	public void toModel_ListWithNosendedMessage() {
		List<User> models = userService.toModel(listNoSendedMessageEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is UserId correct", user.getId() == 1L);
	    Assert.assertTrue("is Username Correct", user.getUser().equals("user1"));
	    Assert.assertTrue("is password Correct", user.getPassword().equals("password"));
	    Assert.assertTrue("Is sended Message null", user.getSentMessages().isEmpty());
	    Assert.assertTrue("Is recived Message id Correct", user.getReceivedMessages().get(0).getId()==1L);
	    Assert.assertTrue("Is recived Message content Correct", user.getReceivedMessages().get(0).getContent().equals("test"));
	
	}
	//TODO
	@Test
	public void toModel_ListWithNoRecivedMessage() {
		List<User> models = userService.toModel(listNoRecivedMessageEntity);
	    User user = models.get(0);
	    Assert.assertTrue("is UserId correct", user.getId() == 1L);
	    Assert.assertTrue("is Username Correct", user.getUser().equals("user1"));
	    Assert.assertTrue("is password Correct", user.getPassword().equals("password"));
	    Assert.assertTrue("Is sended Message id Correct", user.getSentMessages().get(0).getId()==1L);
	    Assert.assertTrue("Is sended Message content Correct", user.getSentMessages().get(0).getContent().equals("test"));
	    Assert.assertTrue("Is recived Message null", user.getReceivedMessages().isEmpty());
	}
}
