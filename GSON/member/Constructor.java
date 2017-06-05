package member;
import java.util.*;

import nodes.Member;
import nodes.Statement;
import nodes.Reference;

public class Constructor extends Member {
	private Statement body;
	private List<Reference> parameters;
	
	public Statement getBody() {
		return body;
	}
	
	public List<Reference> getParameters() {
		return parameters;
	}
}