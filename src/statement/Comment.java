package statement;

import nodes.Statement;

public class Comment extends Statement {
	private String type;
	private String content;
	private String position;
	
	public String getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getPosition() {
		return position;
	}
}