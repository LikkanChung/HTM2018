package story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoryFactory {

	public static Story getStory(String id ) {
		
		final String QUERY = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(DBConfig.HOST_URL, DBConfig.USERNAME, DBConfig.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (con != null) {
			System.out.println("Connected to database");
		} else {
			System.out.println("Failed to connect");
		}
		
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(QUERY);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if (rs != null) {
			System.out.println("Returned a set");
		}
		return new Story("1", "Name of Story", "");
	}
	
	public static Story sampleStory() {
		Story story = new Story("100", "My First Story", "TheCreat0r");
		Part p1 = new Part("101", "The first part", "I can go 2 or 3", null);
		story.addRootPart(p1);
		Part p2 = new Part("102", "Part 2", "From part 2 I can go to 4 or 5", p1);
		Part p3 = new Part("103", "Part 3", "From part 3 I can go to 6 or 7", p1);
		Part p4 = new Part("104", "Part 4", "From part 4 I end", p2);
		Part p5 = new Part("105", "Part 5", "From part 5 I end", p2);
		Part p6 = new Part("106", "Part 6", "From part 6 I end", p3);
		Part p7 = new Part("107", "Part 7", "From part 7 I end", p3);
		
		return story;
	}
}
