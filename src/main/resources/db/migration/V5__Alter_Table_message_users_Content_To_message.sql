START TRANSACTION;

/*ALTER TABLE users_messages DROP FOREIGN KEY content;*/

ALTER TABLE users_messages
CHANGE content message INT(11) NOT NULL;

COMMIT;