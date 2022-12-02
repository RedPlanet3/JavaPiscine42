drop schema if exists chat cascade;

create schema if not exists chat;

CREATE TABLE chat.users (
id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	login varchar NULL,
	"password" varchar NULL
);

CREATE TABLE chat.chatrooms (
id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	chatroom_name varchar NULL,
	chatroom_owner int null,
	FOREIGN KEY (chatroom_owner) REFERENCES chat.users(id)
);

CREATE TABLE chat.messages (
id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	message_author int not NULL,
	message_room int not NULL,
	FOREIGN KEY (message_author) REFERENCES chat.users(id),
	FOREIGN KEY (message_room) REFERENCES chat.chatrooms(id),
	message_text varchar NULL,
	"message_date/time" timestamp NULL
);