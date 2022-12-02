package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private DataSource dataSourse;

    public ProductsRepositoryJdbcImpl(DataSource dataSourse) {
        this.dataSourse = dataSourse;
    }

    @Override
    public List<Product> findAll() {
        List<Product> prodList = new ArrayList<>();
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from Product;");
            while (res.next()) {
                prodList.add(new Product(res.getLong("identifier"),
                        res.getString("name"),
                        res.getInt("price")));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodList;
    }


    @Override
    public void update(Product product) {
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();

            String str = (
                    "UPDATE Product SET name = '" +
                            product.getName() +
                            "' ,price = " + product.getPrice() +
                            " WHERE identifier = " + Integer.parseInt(product.getIdentifier().toString()));


            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();

            String str = (
                    "INSERT INTO Product (name, price)" +
                            "VALUES ( '" +
                            product.getName() +
                            "'," + product.getPrice() + ");");
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        if (findById(id).isPresent()) {
            try {
                Connection connection = this.dataSourse.getConnection();
                Statement statement = connection.createStatement();

                String str = (
                        "DELETE FROM Product WHERE identifier =" + id + ";");
                statement.executeUpdate(str);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product mg = null;
        try {
            Connection connection = this.dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("Select * from Product where identifier = " + id);
            if (!res.next()) {
                return Optional.empty();
            }
                mg = new Product(id,
                        res.getString("name"),
                        res.getInt("price"));

            statement.close();
            return Optional.of(mg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}