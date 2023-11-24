package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void updateUser(){
		int rows = userMapper.updateStatus(149,0);
		System.out.println(rows);

		rows = userMapper.updateHeader(149,"http://www.nowcoder.com/102.png");
		System.out.println(rows);

		rows = userMapper.updatePassword(149,"hello");
		System.out.println(rows);
	}

}
