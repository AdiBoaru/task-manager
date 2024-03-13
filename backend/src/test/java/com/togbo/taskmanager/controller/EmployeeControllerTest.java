package java.com.togbo.taskmanager.controller;

import com.togbo.taskmanager.controller.EmployeeController;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {

    }
}
