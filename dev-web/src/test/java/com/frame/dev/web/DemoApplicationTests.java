package com.frame.dev.web;

import com.frame.dev.web.entity.User;
import com.frame.common.rabbitmq.RabbitMqUtils;
import com.frame.common.utils.JacksonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private RabbitMqUtils rabbitMqUtils;
	@Test
	public void contextLoads() {
	}

	@Test
	public void sendMsg(){
		User user = new User();
		user.setId(1L);
		user.setName("derrick");
		try {
			//topic1MessageSender.send(user);
			rabbitMqUtils.send("topic_test_exchange","key1", JacksonUtils.obj2json(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void sendFMsg(){
//		rabbitMqUtils.convertAndSend("fanout_test_exchange",null,"fanout消息+++++++++++++++++++");
	}
	/*@Test
	public void sendFMsgadasda(){
		rabbitMqConfig.seng();
	}*/


}
