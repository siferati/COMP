package statement;

import nodes.Expression;
import nodes.Statement;

public class If extends Statement {
	private Expression condition;
	private Statement then;
	private Statement elseVar;
	
	public Expression getCondition() {
		return condition;
	}
	
	public Statement getThen() {
		return then;
	}
	
	public Statement getElse() {
		return elseVar;
	}
}