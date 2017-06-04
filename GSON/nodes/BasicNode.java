package nodes;

import java.util.*;

public abstract class BasicNode{
	private String nodetype;
	private String location;
    // private List<Comment> comments; 
	
	public String getNodetype() {
		return nodetype;
	}
	
	public String getLocation() {
		return location;
	}
	
	/*public List<Comment> getComments() {
		return comments;
	}*/
}