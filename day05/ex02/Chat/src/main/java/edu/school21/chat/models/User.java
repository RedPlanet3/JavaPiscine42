package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> userSocializes;

    public User(long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> userSocializes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.userSocializes = userSocializes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getUserSocializes() {
        return userSocializes;
    }

    public void setUserSocializes(List<Chatroom> userSocializes) {
        this.userSocializes = userSocializes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public boolean equals(Object obj) {
        return  (this.id == ((User)obj).id) &&
                (this.login == ((User)obj).login) &&
                (this.password == ((User)obj).password);
    }

    @Override
    public String toString() {
        return this.login;
    }
}
