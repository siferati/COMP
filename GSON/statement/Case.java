package statement;

import java.util.List;

import nodes.Expression;
import nodes.Statement;

public class Case extends Statement {
	private Expression expression;
	private List<Statement> statements;
	
	public Expression getExpression() {
		return expression;
	}
	public List<Statement> getStatements() {
		return statements;
	}
}