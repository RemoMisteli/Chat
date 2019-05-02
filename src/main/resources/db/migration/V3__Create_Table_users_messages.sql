CREATE TABLE users_messages(
 sender INT NOT NULL,
 receiver INT NOT NULL,
 message INT NOT NULL
 );
 
 ALTER TABLE users_messages
 ADD FOREIGN KEY (sender) REFERENCES users(id);
 
 ALTER TABLE users_messages
 ADD FOREIGN KEY (receiver) REFERENCES users(id);
 
  ALTER TABLE users_messages
 ADD FOREIGN KEY (message) REFERENCES messages(id);