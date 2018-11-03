package story;

import java.util.ArrayList;

public class Part {
	public String partID;
	public String title;
	public String body;
	public Part parentID;
	public ArrayList<Part> children;
	
	public Part(String part, String t, String b, Part p) {
		this.partID = part;
		this.title = t;
		this.body = b;
		if (p!=null) {p.children.add(this);}
	}
	

	
}
