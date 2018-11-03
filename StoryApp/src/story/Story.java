package story;

public class Story {
	public String storyID;
	public String name;
	public String creator;
	public Part root;
	
	public Story(String id, String n, String c) {
		this.storyID = id;
		this.name = n;
		this.creator = c;
	}
	
	public void addRootPart(Part part) {
		this.root = part;
	}
}
