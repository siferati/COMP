package expression;


import nodes.Expression;
import nodes.Reference;

public class LocalVariableReference extends Expression {
	private String name;
	private Reference type;
	
	public Reference getTypeReference() {
		return type;
	}
	
	public String getName() {
		return name;
	}
}