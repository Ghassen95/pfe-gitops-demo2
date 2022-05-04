package tn.esprit.spring;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;


import tn.esprit.spring.services.UserServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration

public class TimesheetDevops1Application {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetDevops1Application.class, args);
	}
	UserServiceImpl us=null;
	String string = "2015-03-20";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.parse(string, formatter);

	//User u = new User("Ali","Ben ahmed",date,Role.ADMINISTRATEUR);
	//User userAdded = us.addUser(u);

	
	

}
