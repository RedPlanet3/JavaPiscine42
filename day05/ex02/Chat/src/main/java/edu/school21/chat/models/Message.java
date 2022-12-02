package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime date;

    public Message(Long id, User author, Chatroom room, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDateTime(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, date);
    }

    @Override
    public boolean equals(Object obj) {
        return  (this.id == ((Message)obj).id) &&
                (this.author == ((Message)obj).author) &&
                (this.room == ((Message)obj).room) &&
                (this.text == ((Message)obj).text) &&
                (this.date == ((Message)obj).date);
    }

    @Override
    public String toString() {
        return "User" + this.author + " " + this.date + ": [" + this.room + "]" + this.text;
    }
}
