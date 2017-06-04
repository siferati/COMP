package expression;
import nodes.Expression;

public class Literal extends Expression { //Aqui não estendi de BasicNode mas sim de expression, para poder ser usado como uma expressão!
	private String value;
	
	public String getValue() {
		return value;
	}
}