package app;

import app.domain.Instructor;
import app.repository.InstructorRepository;
import app.utility.Utility;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IsaProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(IsaProjectApplication.class, args);
	}

}
