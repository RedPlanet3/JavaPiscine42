package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ProductsRepositoryJdbcImplTest {

    EmbeddedDatabase db;
    private ProductsRepository repo;
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0l, "potato",20),
            new Product(1l, "banana",35),
            new Product(2l, "peach",40),
            new Product(3l, "apple",12),
            new Product(4l, "pineapple",60));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "peach",40);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3L, "potato",44);
    final Product EXPECTED_SAVED_PRODUCT = new Product(5L, "lemon",26);

    final List<Product> PRODUCTS_AFTER_DELETE = Arrays.asList(
            new Product(0l, "potato",20),
            new Product(2l, "peach",40),
            new Product(3l, "apple",12),
            new Product(4l, "pineapple",60));


    @BeforeEach
    void init(){
        this.db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();
        repo = new ProductsRepositoryJdbcImpl(this.db);
    }

    @AfterEach
    void closeDB()
    {
        this.db.shutdown();
    }


    @Test
    public void findAllTest() {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, repo.findAll());
    }

    @Test
    public void findByIdTest() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, repo.findById(2L).get());
        Assertions.assertEquals(Optional.empty(), repo.findById(10l));
        Assertions.assertEquals(Optional.empty(), repo.findById(null));
    }

    @Test
    public void updateTest() throws SQLException {
        repo.update(new Product(3L, "potato",44));
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, repo.findById(3L).get());
    }

    @Test
    public void saveTest() throws SQLException {
        repo.save(new Product(5L, "lemon", 26));
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, repo.findById(5L).get());
    }

    @Test
    public void deleteTest() throws SQLException {
        repo.delete(1L);
        Assertions.assertEquals(PRODUCTS_AFTER_DELETE, repo.findAll());
        Assertions.assertFalse(repo.findById(1L).isPresent());
    }

}