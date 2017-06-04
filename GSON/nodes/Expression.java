package nodes;

import expression.Literal;
import nodes.BasicNode;

public abstract class Expression extends BasicNode{
	protected Reference type;

	public Reference getTypeReference() {
		return type;
	}

	public String analyze() {

		String retorno = "";

		switch (getNodetype()) {

			case "Literal":
				Literal literal = (Literal) this;

				// get value
				String literalValue = literal.getValue();

				// store initialization
				retorno = literalValue;
				break;

			default:
				System.out.println("Unsupported note type");
				break;

		}

		return retorno;
	}
}
