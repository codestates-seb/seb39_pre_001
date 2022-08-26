package com.preproject.preproject.users;

import com.preproject.preproject.users.controller.UsersController;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UsersController.class)
@AutoConfigureRestDocs
public class UserControllerTest {
}
