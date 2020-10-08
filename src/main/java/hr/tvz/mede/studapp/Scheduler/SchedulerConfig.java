package hr.tvz.mede.studapp.Scheduler;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail objavaJobDetail() {
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob").storeDurably().build();
    }
    @Bean
    public Trigger objavaJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(objavaJobDetail())
                .withIdentity("objavaTrigger").withSchedule(scheduleBuilder).build();
    }


}
