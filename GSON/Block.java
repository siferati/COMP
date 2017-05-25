import java.util.*;

public class Block extends Statement {
	private List<Statement> statements;
	private List<Expression> arguments;
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	public List<Expression> getArguments() {
		return arguments;
	}
}