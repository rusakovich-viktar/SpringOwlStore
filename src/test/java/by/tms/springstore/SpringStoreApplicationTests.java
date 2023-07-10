package by.tms.springstore;

import static org.assertj.core.api.Assertions.assertThat;

import by.tms.springstore.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStoreApplicationTests {
    @Autowired
    private UserController userController;

    @Test
    void test_userController_isExist() {

        assertThat(userController).isNotNull();

    }
}
