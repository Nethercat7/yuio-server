package com.zfy.yuio;

import com.zfy.yuio.utils.ShiroUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YuioApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println(ShiroUtil.pwd2MD5("123456", "k(3!EJC", 1739));
	}

}
