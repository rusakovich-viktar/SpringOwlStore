package by.tms.springstore;

import static org.assertj.core.api.Assertions.assertThat;

import by.tms.springstore.controller.AdminController;
import by.tms.springstore.controller.AuthController;
import by.tms.springstore.controller.CartController;
import by.tms.springstore.controller.CategoryController;
import by.tms.springstore.controller.EmailController;
import by.tms.springstore.controller.HomeController;
import by.tms.springstore.controller.OtherPagesController;
import by.tms.springstore.controller.ProductController;
import by.tms.springstore.controller.SecurityController;
import by.tms.springstore.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStoreApplicationTests {
    @Autowired
    private AdminController adminController;
    @Autowired
    private AuthController authController;
    @Autowired
    private CartController cartController;
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private EmailController emailController;
    @Autowired
    private HomeController homeController;
    @Autowired
    private OtherPagesController otherPagesController;
    @Autowired
    private ProductController productController;
    @Autowired
    private SecurityController securityController;
    @Autowired
    private UserController userController;

    @Test
    void test_adminController_isExist() {
        assertThat(adminController).isNotNull();
    }

    @Test
    void test_authController_isExist() {
        assertThat(authController).isNotNull();
    }

    @Test
    void test_cartController_isExist() {
        assertThat(cartController).isNotNull();
    }

    @Test
    void test_categoryController_isExist() {
        assertThat(categoryController).isNotNull();
    }

    @Test
    void test_emailController_isExist() {
        assertThat(emailController).isNotNull();
    }

    @Test
    void test_homeController_isExist() {
        assertThat(homeController).isNotNull();
    }

    @Test
    void test_otherPagesController_isExist() {
        assertThat(otherPagesController).isNotNull();
    }

    @Test
    void test_productController_isExist() {
        assertThat(productController).isNotNull();
    }


    @Test
    void test_securityController_isExist() {
        assertThat(securityController).isNotNull();
    }

    @Test
    void test_userController_isExist() {
        assertThat(userController).isNotNull();
    }
}
