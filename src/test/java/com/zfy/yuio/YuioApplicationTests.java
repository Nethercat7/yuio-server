package com.zfy.yuio;

import org.junit.jupiter.api.Test;

import java.util.Random;

//@SpringBootTest
class YuioApplicationTests {

    @Test
    void contextLoads() {
        Random random=new Random();
        System.out.println(random.nextInt(10));
    }
}
