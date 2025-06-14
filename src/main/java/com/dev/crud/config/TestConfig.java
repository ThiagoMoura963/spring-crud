package com.dev.crud.config;

import com.dev.crud.entities.Category;
import com.dev.crud.entities.Order;
import com.dev.crud.entities.Product;
import com.dev.crud.entities.User;
import com.dev.crud.entities.enums.OrderStatus;
import com.dev.crud.repositories.CategoryRepository;
import com.dev.crud.repositories.OrderRespository;
import com.dev.crud.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Hardware");
        Category category2 = new Category(null, "Periféricos");

        Product product1 = new Product(null, "Nvidia RTX 4060", "Placa de vídeo NVIDIA GeForce RTX 4060 com 8 GB GDDR6, arquitetura Ada Lovelace, ray tracing e DLSS 3 para alto desempenho em jogos e criação de conteúdo.", 2500.00, "");
        Product product2 = new Product(null, "AMD Ryzen 5 7600X", "Processador AMD Ryzen 5 7600X com 6 núcleos e 12 threads, arquitetura Zen 4, clock de até 5.3GHz e suporte ao padrão AM5 para alto desempenho em jogos e multitarefas.", 1500.00, "");
        Product product3 = new Product(null, "Headset Redragon Zeus X H510-RGB", "Headset gamer com som surround 7.1, drivers de 53mm, iluminação RGB e microfone destacável. Conforto e imersão para longas sessões de jogo.", 300.00,"");
        Product product4 = new Product(null, "FE0F Teclado Mecânico Redragon Kumara K552 RGB", "Teclado mecânico compacto com switches Outemu, iluminação RGB personalizável, estrutura em metal e resistência ideal para jogos intensos.", 199.00,"");

        categoryRepository.saveAll(Arrays.asList(category1, category2));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

        User user2 = new User(null,"Henrique", "henrique@gmail.com", "13999999999", "123");
        User user3 = new User(null, "Lorenzo", "lorenzo@gmail.com", "13999999999", "1234b");

        Order order1 = new Order(null, Instant.parse("2025-06-14T10:43:12Z"), user2, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2025-06-05T15:24:23Z"), user3, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(user2, user3));
        orderRespository.saveAll(Arrays.asList(order1, order2));
    }
}
