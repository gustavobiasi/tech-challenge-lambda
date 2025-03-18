package helloworld.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

import static helloworld.constants.Constants.DB_HOST;
import static helloworld.constants.Constants.DB_NAME;
import static helloworld.constants.Constants.DB_PASSWORD;
import static helloworld.constants.Constants.DB_PORT;
import static helloworld.constants.Constants.DB_USER;


public class Connections {

    public Connection connect() {
        try {
            String uriConnection = String.format("jdbc:postgresql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(uriConnection);
            config.setUsername(DB_USER);
            config.setPassword(DB_PASSWORD);
            config.setMaximumPoolSize(10);
            return new HikariDataSource(config).getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro conectar no banco de dados", e);
        }
    }

}
