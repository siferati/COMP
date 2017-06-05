package statement;

import nodes.Statement;
import nodes.Expression;

public class While extends Statement {
	private Expression condition;
	private Statement body;
	
	public Expression getCondition() {
		return condition;
	}
	
	public Statement getBody() {
		return body;
	}
}