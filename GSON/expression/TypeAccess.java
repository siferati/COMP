package expression;

import nodes.Expression;
import nodes.Reference;

public class TypeAccess extends Expression {
	private Reference target;
	
	public Reference getTarget() {
		return target;
	}
}