package story;
// CLASS THAT CREATES A DB STRUCTURE

import java.sql.*;

public class DBCreate {
	
	private static final String STORY = "CREATE TABLE IF NOT EXISTS Story (\n"
									  + "StoryID	int			,\n"
									  + "Name		varchar(20)	,\n"
									  + "Creator    varchat(20)	,\n"
									  + "PRIMARY KEY (StoryID)	";
	private static final String PART = "CREATE TABLE IF NOT EXISTS Part (\n"
									 + "PartID		int			,\n"
									 + "Title		varchar(50)	,\n"
									 + "Body		varchar(280),\n"
									 + "StoryID 	int			,\n"
									 + "ParentID	int			,\n"
									 + "PRIMARY KEY (PartID)	,\n"
									 + "FOREIGN KEY (StoryID) REFERENCES Story(StoryID),\n"
									 + "FOREIGN KEY (ParentID) REFERENCES Part(PartID)";
									 
	public static void main(String[] args) {
			
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
		try {
			stmt = con.createStatement();
			stmt.execute(STORY);
			stmt.execute(PART);
			System.out.println("Finished executing");
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
