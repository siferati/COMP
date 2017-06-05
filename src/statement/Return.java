package statement;

import nodes.Statement;
import nodes.Expression;

public class Return extends Statement {
	private Expression expression;
	
	public Expression getExpression() {
		return expression;
	}
}