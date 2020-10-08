package hr.tvz.mede.studapp.Scheduler;

import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Service.StudentService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class SampleJob extends QuartzJobBean {

    @Autowired
    private StudentService studentService;
    private String name;

    public SampleJob() {
    }

    // Inject the "name" job data property
    public void setName(String name) {

    }


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<StudentDTO> studentDTOList = studentService.getAll();
        System.out.println("Ovo su trenutno upisani sudenti");
        System.out.println("--------------------------------");
        for(StudentDTO s : studentDTOList){
            System.out.println(s.getJmbag() + " - " + s.getFirstName() + " " + s.getLastName());
        }
        System.out.println("--------------------------------");

    }
}
