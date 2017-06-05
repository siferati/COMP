package expression;


import nodes.Expression;

public class LocalVariableReference extends Expression {
	private String name;

	public String getName() {
		return name;
	}
}