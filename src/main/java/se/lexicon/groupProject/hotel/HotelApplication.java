package se.lexicon.groupProject.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.groupProject.data.MyDataSource;

import java.sql.SQLException;

@SpringBootApplication
public class HotelApplication {
	public static void main(String[] args) throws SQLException {
		MyDataSource.getConnection();

		SpringApplication.run(HotelApplication.class, args);
	}
}
