package org.ssm.dufy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.simpl.RAMJobStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.job.HelloWorldJob;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class IUserServiceTest {

	@Autowired
	public IUserService userService;
	@Autowired
	public QuartzService quartzService;
	@Autowired
	private Scheduler quartzScheduler;
	
	@Test
	public void getUserByIdTest(){
	 
		User user = userService.getUserById(1);
		System.out.println(user.getUserName());
	}

	@Test
	public void test() throws Exception{
		//quartzService.addJob("job1","jobg1","t1","tg1", HelloWorldJob.class,"0/3 * * * * ?");
		// 重启触发器
		//quartzScheduler.resumeTrigger(TriggerKey.triggerKey("t1", "tg1"));
		//quartzService.modifyJobTime("t1","tg1","0/6 * * * * ?");
		//quartzScheduler.start();
        quartzService.modifyJobTime("job3","jobg3","t3","tg3","job3","jobg3","t3","tg3","0/5 * * * * ?");
		//quartzService.addJob("job3","jobg3","t3","tg3",HelloWorldJob.class,"0/3 * * * * ?");
	}


}
