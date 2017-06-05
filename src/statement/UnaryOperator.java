package statement;

import nodes.Expression;
import nodes.Reference;
import nodes.Statement;

public class UnaryOperator extends Statement {
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