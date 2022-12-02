package edu.school21.repositories;

import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
    EmbeddedDatabase db;

    @BeforeEach
    void init(){
        this.db = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .setType(EmbeddedDatabaseType.HSQL)
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();
    }

    @Test
    void checkConnection() throws SQLException {
        Assertions.assertNotNull(this.db.getConnection());
    }
}
