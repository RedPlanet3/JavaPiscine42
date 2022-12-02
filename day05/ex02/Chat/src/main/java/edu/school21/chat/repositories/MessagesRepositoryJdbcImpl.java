package edu.school21.chat.repositories;


import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private DataSource dataSourse;
    public MessagesRepositoryJdbcImpl(DataSource dataSourse) {
        this.dataSourse = dataSourse;
    }

    @Override
    public Optional<Message> findById(Long id) {
        Message mg = null;
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from chat.messages where id = " + id);
            res.next();
            User user = getUser(res.getLong("message_author"));
            Chatroom room = getRoom(res.getLong("message_room"), user);
            mg = new Message(Long.parseLong(id.toString()) ,
                    user,
                    room,
                    res.getString("message_text"),
                    res.getTimestamp("message_date/time").toLocalDateTime());
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(mg);
    }

    @Override
    public void update(Message message) {
        try {
        Connection connection = this.dataSourse.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = null;

        String str = (
                "UPDATE chat.messages SET " +
                        "message_author =" + message.getAuthor().getId() +
                        ",message_room =" + message.getRoom().getId() +
                        ",message_text =" + "'" + message.getText() + "'" +
                        ",\"message_date/time\" =" + message.getDate() +
                        " where id = " + message.getId());

            statement.executeUpdate(str);
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Table has not update");
        }
    }

    @Override
    public void save(Message message) {
        try {
        if (getUser(message.getAuthor().getId()) == null)
            throw new NotSavedSubEntityException("Table has not save");
        if (getUser(message.getRoom().getId()) == null)
            throw new NotSavedSubEntityException("Table has not save");

            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();

            String str = (
                    "INSERT INTO chat.messages (message_author, message_room, message_text, \"message_date/time\")" +
                            "VALUES ( " +
                            message.getAuthor().getId() +
                            "," + message.getRoom().getId() +
                            "," + "'" + message.getText() + "'" +
                            "," + "'" + Timestamp.valueOf(message.getDate()) + "'" + ") RETURNING id;" );
            ResultSet res = statement.executeQuery(str);
            res.next();
            message.setId(res.getLong(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Table has not save");
        }
    }

    public void saveUser(User user)
    {
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();

            String str = ("INSERT INTO chat.users (login, password)" +
                    "VALUES" +
                    "('" + user.getLogin() +  "','" + user.getPassword() + "');");

            statement.executeUpdate(str);
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Table has not save");
        }
    }

    public void saveChatroom(Chatroom room)
    {
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();

            String str = ("INSERT INTO chat.chatrooms (chatroom_name, chatroom_owner)\n" +
                    "VALUES\n" +
                    "    ('" + room.getName() + "'," + room.getOwner().getId() +");");

            statement.executeUpdate(str);
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Table has not save");
        }
    }

    public User getUser(Long id) throws SQLException {
        Connection connection = this.dataSourse.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from chat.users where id = " + id);
        if (res.next())
            return new User(id, res.getString("login"), res.getString("password"), null, null);
        else
            return null;
    }
    public Chatroom getRoom(Long id, User user) throws SQLException {
        Connection connection = this.dataSourse.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from chat.chatrooms where id = " + id);
        if (res.next())
            return new Chatroom(id, res.getString("chatroom_name"), user, null);
        else
            return null;
    }

}