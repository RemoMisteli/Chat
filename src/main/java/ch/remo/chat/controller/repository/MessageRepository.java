package ch.remo.chat.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.remo.chat.controller.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long>{

}
