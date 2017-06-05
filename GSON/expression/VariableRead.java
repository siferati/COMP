package expression;
import nodes.Expression;

public class VariableRead extends Expression {
	private Expression var;
	
	public Expression getVar() {
		return var;
	}
}