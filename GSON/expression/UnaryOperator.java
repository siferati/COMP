package expression;

import nodes.Expression;
import nodes.Reference;

public class UnaryOperator extends Expression {
	private String operator;
	private Expression operand;
	private Reference type;
	
	public Reference getTypeReference() {
		return type;
	}	
	public String getOperator() {
		return operator;
	}
	
	public Expression getOperand() {
		return operand;
	}
}