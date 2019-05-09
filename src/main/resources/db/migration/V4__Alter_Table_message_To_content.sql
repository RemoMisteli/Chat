START TRANSACTION;

ALTER TABLE messages
CHANGE message content varchar(255) NOT NULL;

ALTER TABLE users_messages
CHANGE message content INT(11) NOT NULL;
 
 ALTER TABLE users_messages
 ADD FOREIGN KEY (content) REFERENCES messages(id);
 COMMIT;