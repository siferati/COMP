package statement;

import java.util.List;

import nodes.Expression;
import nodes.Statement;

public class Switch extends Statement {
	private Expression condition;
	private List<Statement> cases;
	
	public Expression getCondition() {
		return condition;
	}
	public List<Statement> getCases() {
		return cases;
	}
	
}