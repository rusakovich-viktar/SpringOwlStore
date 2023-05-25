//package by.tms.springstore.repository.utils;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//
//@Component
//@RequiredArgsConstructor
//public class ConnectionWrapper implements AutoCloseable {
//
//    private final Connection connection;
//    private final ConnectionPool connectionPool;
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    @Override
//    public void close() throws Exception {
//        connectionPool.closeConnection(this);
//    }
//}
