package com.qp.assesment;

import com.qp.assesment.entity.RoleEntity;
import com.qp.assesment.entity.UserEntity;
import com.qp.assesment.entity.constants.RoleEnum;
import com.qp.assesment.repository.RoleRepo;
import com.qp.assesment.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class QpAssesmentApplication{

    public static void main(String[] args) {
        SpringApplication.run(QpAssesmentApplication.class, args);
    }

}
