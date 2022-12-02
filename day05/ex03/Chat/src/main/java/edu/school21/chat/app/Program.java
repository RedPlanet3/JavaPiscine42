package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        HikariConfig db = new HikariConfig();
        db.setJdbcUrl("jdbc:postgresql://localhost:5432/java_piscine");
        db.setUsername("postgres");
        db.setPassword("postgres");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(new HikariDataSource(db));
        Optional<Message> messageOptional = messagesRepository.findById(50L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye Bye");
            message.setDateTime(null);
            messagesRepository.update(message);
        }
    }
}
