package nodes;

import expression.BinaryOperator;
import expression.FieldRead;
import expression.Literal;
import expression.LocalVariableReference;
import expression.TypeAccess;
import expression.UnaryOperator;
import expression.VariableRead;
import expression.VariableWrite;
import nodes.BasicNode;

public class Expression extends BasicNode {
	public String analyze(String pattern) {

		String retorno = "";

		switch (getNodetype()) {

			case "Literal":
				Literal literal = (Literal) this;

				// get value
				String literalValue = literal.getValue();

				// store initialization
				retorno = literalValue;
				break;

			case "BinaryOperator":
				BinaryOperator binaryOp = (BinaryOperator) this;

				Expression lhsExp = binaryOp.getLhs();
				Expression rhsExp = binaryOp.getRhs();
				String op = binaryOp.getOperator();
				Reference type = (Reference)binaryOp.getTypeReference();

				String lhs = lhsExp.analyze(pattern);
				String rhs = rhsExp.analyze(pattern);

				//System.out.println("BinaryOperator: " + lhs + " " + op + " " + rhs);

				String temp = lhs + " " + op + " " + rhs;
				retorno += temp;

				if(type != null) {
					type.analyze(pattern);
				}

				break;
			case "UnaryOperator":
				UnaryOperator unaryOperator = (UnaryOperator) this;

				String unary_op = unaryOperator.getOperator();
				Expression operand = unaryOperator.getOperand();

				String tmpOp = "";
				switch(unary_op) {
					case "_++":
						tmpOp = "++";
						break;
					case "_--":
						tmpOp = "--";
						break;
					default:
						//System.out.println("UnaryOperator - error: wrong operator");
				}

				String res = operand.analyze(pattern);
				//System.out.println("UnaryOperator: " + res + tmpOp);

				temp = res + tmpOp;
				retorno += temp;

				break;
			case "VariableRead":
				VariableRead varRead = (VariableRead) this;

				type = varRead.getTypeReference();
				Expression var = varRead.getVar();

				if(type != null)
					var.analyze(pattern);

				if(var != null)
					retorno = var.analyze(pattern);

				break;
			case "LocalVariableReference":
				LocalVariableReference localVarRef = (LocalVariableReference) this;

				String name = localVarRef.getName();
				type = localVarRef.getTypeReference();

				if(name != null)
					//System.out.println("LocalVariableReference - Name: " + name);

				if(type != null)
					type.analyze(pattern);

				retorno = name;

				break;
			case "TypeAccess":
				TypeAccess typeAcc = (TypeAccess) this;

				Reference target = typeAcc.getTarget();
				type = typeAcc.getTypeReference();

				if(target != null)
					target.analyze(pattern);

				if(type != null)
					type.analyze(pattern);

				break;
			case "FieldRead":
				FieldRead fieldRead = (FieldRead) this;

				Expression targetFR = fieldRead.getTarget();
				Reference varFR = fieldRead.getVar();
				type = fieldRead.getTypeReference();

				if(targetFR != null)
					targetFR.analyze(pattern);

				if(varFR != null)
					varFR.analyze(pattern);

				if(type != null)
					type.analyze(pattern);
				break;
			case "VariableWrite":
				VariableWrite variableWrite = (VariableWrite) this;

				Expression varVW = variableWrite.getVar();
				type = variableWrite.getTypeReference();

				if(varVW != null)
					retorno = varVW.analyze(pattern);

				if(type != null)
					type.analyze(pattern);

				break;
			case "NullNode":
				break;
			default:
				//System.out.println("Unsupported note type");
				break;

		}

		return retorno;
	}
}
