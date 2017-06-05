package statement;

import java.util.List;

import nodes.Statement;
import nodes.Expression;
import nodes.Reference;

public class Invocation extends Statement {
	private Reference executable;
	private List<Expression> arguments;
	private Expression target;
	
	public Reference getExecutable() {
		return executable;
	}
	
	public List<Expression> getArguments() {
		return arguments;
	}
	
	public Expression getTarget() {
		return target;
	}
}