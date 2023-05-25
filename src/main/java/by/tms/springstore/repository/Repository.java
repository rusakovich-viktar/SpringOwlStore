//package by.tms.springstore.repository;
//
//import by.tms.springstore.repository.utils.ConnectionPool;
//import by.tms.springstore.repository.utils.ConnectionWrapper;
//
//public interface Repository {
//
//    default ConnectionWrapper getConnectionWrapper() throws Exception {
//        return ConnectionPool.getInstance().getConnectionWrapper();
//    }
//}
