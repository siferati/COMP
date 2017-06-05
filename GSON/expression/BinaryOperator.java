package expression;

import nodes.Expression;

public class BinaryOperator extends Expression { //aqui não estendi de BasicNode para esta classe poder ser usada como expression
	private String operator;
    private Expression lhs; //aqui defino lhs e rhs como Expression pois elas deverão poder conter qualquer expressão, e não obrigatóriamente uma VariableRead ou Literal como acima
	private Expression rhs;
	
	public String getOperator() {
		return operator;
	}
	
	public Expression getLhs() {
		return lhs;
	}
	
	public Expression getRhs() {
		return rhs;
	}
}