package expression;

import nodes.Expression;
import nodes.Reference;

public class TypeAccess extends Expression {
	private Reference target;
	private Reference type;
	
	public Reference getTypeReference() {
		return type;
	}	
	public Reference getTarget() {
		return target;
	}
}