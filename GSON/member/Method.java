package member;
import java.util.*;

import nodes.Member;
import nodes.Reference;
import nodes.Statement;
import reference.Parameter;

public class Method extends Member {
	private Reference type;
	private Statement body;
	private List<Parameter> parameters;
	
	public Reference getType() {
		return type;
	}
	
	public Statement getBody() {
		return body;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
}