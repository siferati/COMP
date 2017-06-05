package statement;

import java.util.List;

import nodes.Expression;
import nodes.Statement;

public class For extends Statement {
	private List<Statement> init;
	private Expression condition;
	private List<Expression> update;
	private Statement body;
	
	public List<Statement> getInit() {
		return init;
	}
	public Expression getCondition() {
		return condition;
	}
	public List<Expression> getUpdate() {
		return update;
	}
	public Statement getBody() {
		return body;
	}
}