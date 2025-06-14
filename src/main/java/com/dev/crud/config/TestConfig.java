package com.dev.crud.config;

import com.dev.crud.entities.Category;
import com.dev.crud.entities.Order;
import com.dev.crud.entities.User;
import com.dev.crud.entities.enums.OrderStatus;
import com.dev.crud.repositories.CategoryRepository;
import com.dev.crud.repositories.OrderRespository;
import com.dev.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRespository orderRespository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Hardware");
        Category category2 = new Category(null, "Periféricos");

        categoryRepository.saveAll(Arrays.asList(category1, category2));

        User user2 = new User(null,"Henrique", "henrique@gmail.com", "13999999999", "123");
        User user3 = new User(null, "Lorenzo", "lorenzo@gmail.com", "13999999999", "1234b");

        Order order1 = new Order(null, Instant.parse("2025-06-14T10:43:12Z"), user2, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2025-06-05T15:24:23Z"), user3, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(user2, user3));
        orderRespository.saveAll(Arrays.asList(order1, order2));
    }
}
