package member;
import java.util.*;

import nodes.Member;
import nodes.Reference;
import nodes.Statement;

public class Method extends Member {
	private Reference type;
	private Statement body;
	private List<Reference> parameters;
	
	public Reference getType() {
		return type;
	}
	
	public Statement getBody() {
		return body;
	}
	
	public List<Reference> getParameters() {
		return parameters;
	}
}