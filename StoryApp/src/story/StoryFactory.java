package story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class StoryFactory {

	private static ResultSet getResult(String sqlquery) {
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
				
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlquery);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return rs;
	}
	
	public static ArrayList<Story> getStories(){
		final String QUERY = "SELECT * FROM story";
		ResultSet rs = getResult(QUERY);
		ArrayList<Story> list = new ArrayList<Story>();
		try {
			while(!rs.isLast()) {
				rs.next();
				int StoryID = rs.getInt(1);
				String name = rs.getString(2);
				String creator = rs.getString(3);
				list.add(new Story(StoryID, name, creator));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static ArrayList<Story> getStoriesById(int storyID) {
		final String QUERY = "SELECT * FROM story WHERE story.storyID=" + storyID;
		ResultSet rs = getResult(QUERY);
		ArrayList<Story> list = new ArrayList<Story>();
		try {
			while(!rs.isLast()) {
				rs.next();
				int StoryID = rs.getInt(1);
				String name = rs.getString(2);
				String creator = rs.getString(3);
				list.add(new Story(StoryID, name, creator));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Story getStory(String id ) {
		
		final String QUERY = "SELECT * FROM story, part WHERE story.storyID=part.storyID";
		
		ResultSet rs = getResult(QUERY);
		
		Story ret = null;
		HashMap<Integer,Part> parts = new HashMap<Integer,Part>(); 
		if (rs != null) {
			System.out.println("Returned a set");
			
			try {
				while (!rs.isLast()) {
					rs.next();
					int storyID = rs.getInt(1);
					String name = rs.getString(2);
					String creator = rs.getString(3);
					int partID = rs.getInt(4);
					String title = rs.getString(5);
					String body = rs.getString(6);
					int parentID = rs.getInt(7);
					
				//	System.out.println("Story: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nCreator: " + rs.getString(3) + "\nPart:" + rs.getInt(4) + "\nBody: " + rs.getString(6) + "\nParent: " + rs.getInt(7));
				
					Part part = new Part(partID, title, body, parentID);
					parts.put(partID, part);
					if (parentID == 0) {
						// is a root of story
						ret = new Story(storyID, name, creator);
						ret.addRootPart(part);
					} 
				}
				
				for (Entry<Integer, Part> p : parts.entrySet()) {
					//set each as a child inside the parent
					if (p.getValue().getParentInt() != 0) {
						parts.get(p.getValue().getParentInt()).addChild(p.getValue());
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// convert rs into a story
		
		return ret;
	}
	
	public static Story sampleStory() {
		Story story = new Story(100, "My First Story", "TheCreat0r");
		Part p1 = new Part(101, "The first part", "I can go 2 or 3", 0);
		story.addRootPart(p1);
		Part p2 = new Part(102, "Part 2", "From part 2 I can go to 4 or 5", 101);
		p1.addChild(p2);
		Part p3 = new Part(103, "Part 3", "From part 3 I can go to 6 or 7", 101);
		p1.addChild(p3);
		Part p4 = new Part(104, "Part 4", "From part 4 I end", 102);
		p2.addChild(p4);
		Part p5 = new Part(105, "Part 5", "From part 5 I end", 102);
		p2.addChild(p5);
		Part p6 = new Part(106, "Part 6", "From part 6 I end", 103);
		p3.addChild(p6);
		Part p7 = new Part(107, "Part 7", "From part 7 I end", 103);
		p3.addChild(p7);
		
		return story;
	}
}
