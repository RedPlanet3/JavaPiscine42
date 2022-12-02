package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args){
        HikariConfig db = new HikariConfig();
        db.setJdbcUrl("jdbc:postgresql://localhost:5432/java_piscine");
        db.setUsername("postgres");
        db.setPassword("postgres");


        User creator = new User(1L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "wwHello!", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(new HikariDataSource(db));
        messagesRepository.save(message);
        System.out.println(message.getId()); // ex. id == 11
    }
}
