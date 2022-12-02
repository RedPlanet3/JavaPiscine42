package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        HikariConfig db = new HikariConfig();
        db.setJdbcUrl("jdbc:postgresql://localhost:5432/java_piscine");
        db.setUsername("postgres");
        db.setPassword("postgres");
        MessagesRepository repository = new MessagesRepositoryJdbcImpl(new HikariDataSource(db));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter message id");
        System.out.println(repository.findById(input.nextLong()));


    }
}
