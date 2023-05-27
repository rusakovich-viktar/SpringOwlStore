//package by.tms.springstore.repository.impl;
//
//import by.tms.springstore.model.Category;
//import by.tms.springstore.repository.CategoryRepository;
//import by.tms.springstore.repository.utils.ConnectionWrapper;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@AllArgsConstructor
//@Slf4j
//public class CategoryRepositoryImpl /*extends BaseRep*/ implements CategoryRepository {
//
//    private static final String PATH_TO_STORE = "SELECT * FROM \"online-store\".categories";
//
//    @Override
//    public List<Category> getCategories() {
//        List<Category> categories = new ArrayList<>();
//        try (ConnectionWrapper connectionWrapper = connectionPool.getConnectionWrapper();
//             Statement statement = connectionWrapper.getConnection().createStatement()) {
//            ResultSet rs = statement.executeQuery(PATH_TO_STORE);
//            while (rs.next()) {
//                Category category = Category.builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .imagePath(rs.getString("imagePath"))
//                        .build();
//                categories.add(category);
//            }
//        } catch (Exception e) {
//            log.error("Exception in getConnectionWrapper in getCategories ", e);
//        }
//        return categories;
//    }
//
//    @Override
//    public Category getCategory(int id) {
//        return null;
//    }
//}