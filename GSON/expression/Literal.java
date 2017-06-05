package expression;
import nodes.Expression;
import nodes.Reference;

public class Literal extends Expression { //Aqui não estendi de BasicNode mas sim de expression, para poder ser usado como uma expressão!
	private String value;
	private Reference type;
	
	public Reference getTypeReference() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
}