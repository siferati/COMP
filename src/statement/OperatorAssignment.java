package statement;

import nodes.Expression;
import nodes.Reference;
import nodes.Statement;

public class OperatorAssignment extends Statement {
	private Reference type;
	private String operator;
	private Expression lhs;
	private Expression rhs;
	public Reference getType() {
		return type;
	}
	public String getOperator() {
		return operator;
	}
	public Expression getLhs() {
		return lhs;
	}
	public Expression getRhs() {
		return rhs;
	}
}