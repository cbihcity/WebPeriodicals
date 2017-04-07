package by.pvt.heldyieu.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory connectionFactory = null;
    private BasicDataSource dataSource = null;

    private ConnectionFactory() {
        LOGGER.info("Initializing connectionFactory class");

        try {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("Geldiev_1989");
            dataSource.setUrl("jdbc:mysql://localhost:3306/magazines?useSSL=false&amp;autoReconnect=true");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        LOGGER.info("Getting connection");
        return dataSource.getConnection();
    }

    public static synchronized ConnectionFactory getInstance() {
        if(connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
    
}
