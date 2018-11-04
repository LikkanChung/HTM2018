package story;

import java.util.ArrayList;

public class Part {
	public int partID;
	public String title;
	public String body;
	public int parentID;
	public ArrayList<Part> children = new ArrayList<Part>();
	
	public Part(int part, String t, String b, int parent) {
		this.partID = part;
		this.title = t;
		this.body = b;
		this.parentID = parent;
	}
	
	public void addChild(Part p) {
		children.add(p);
	}
	
	public int getParentInt() {
		return parentID;
	}
}
