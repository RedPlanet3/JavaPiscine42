package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            User user = getUser(res.getInt("message_author"));
            Chatroom room = getRoom(res.getInt("message_room"), user);
            mg = new Message(Integer.parseInt(id.toString()) ,
                    user,
                    room,
                    res.getString("message_text"),
                    res.getDate("message_date/time"));
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(mg);
    }

    public User getUser(int id) throws SQLException {
        Connection connection = this.dataSourse.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from chat.users where id = " + id);
        res.next();
        return new User(id, res.getString("login"), res.getString("password"), null, null);
    }
    public Chatroom getRoom(int id, User user) throws SQLException {
        Connection connection = this.dataSourse.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from chat.chatrooms where id = " + id);
        res.next();
        return new Chatroom(id, res.getString("chatroom_name"), user, null);
    }

}