package expression;

import nodes.Expression;
import nodes.Reference;

public class FieldRead extends Expression {
	private Expression target;
	private Reference var;
	private Reference type;
	
	public Expression getTarget() {
		return target;
	}
	
	public Reference getVar() {
		return var;
	}
	
	public Reference getTypeReference() {
		return type;
	}
}