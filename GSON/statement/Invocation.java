package statement;

import java.util.List;

import nodes.Statement;
import nodes.Reference;

public class Invocation extends Statement {
	private Reference executable;
	private List<Statement> arguments;
	
	public Reference getExecutable() {
		return executable;
	}
	
	public List<Statement> getArguments() {
		return arguments;
	}
}