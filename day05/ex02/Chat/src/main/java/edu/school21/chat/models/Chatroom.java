package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner);
    }

    @Override
    public boolean equals(Object obj) {
        return  (this.id == ((Chatroom)obj).id) &&
                (this.name == ((Chatroom)obj).name) &&
                (this.owner == ((Chatroom)obj).owner);
    }

    @Override
    public String toString() {
        return this.name + "/" + this.owner;
    }

    public Chatroom(Long id, String name, User owner, List<Message> listOfMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.listOfMessages = listOfMessages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    private List<Message> listOfMessages;
}
