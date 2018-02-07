package com.medha.crontrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.medha.job.HelloWorld;

public class CronTriggerExample {
	public static void main(String[] args) {
		JobDetail job=JobBuilder.newJob(HelloWorld.class).withIdentity("dummyJobName","group1").build();
		
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("dummyTriggerName","group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		//schedule it
    	Scheduler scheduler = null;
    	
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
	    	scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
