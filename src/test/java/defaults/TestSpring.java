package defaults;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wxl.jk.domain.Factory;
import cn.wxl.jk.service.FactoryService;

/**
 * @Description: 使用spring整合jUnit测试
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014-3-13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestSpring {

	@Test
	public void testService() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("--------------------------->" + ac);
		FactoryService f = (FactoryService) ac.getBean("factoryService");
		List<Factory> list = f.find(null);
		for(Factory factory :list){
			System.out.println(factory.toString());
		}
	}
}
