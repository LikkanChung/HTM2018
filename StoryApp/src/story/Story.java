package story;

public class Story {
	public int storyID;
	public String name;
	public String creator;
	public Part root;
	
	public Story(int id, String n, String c) {
		this.storyID = id;
		this.name = n;
		this.creator = c;
	}
	
	public void addRootPart(Part part) {
		this.root = part;
	}
	
	public String toString() {
		return storyID + ": " + name + ", by " + creator;
			
	}

}
