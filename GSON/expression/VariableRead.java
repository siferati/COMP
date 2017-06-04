package expression;
import nodes.Expression;

public class VariableRead extends Expression {
	private Expression reference;
	
	public Expression getReference() {
		return reference;
	}
}