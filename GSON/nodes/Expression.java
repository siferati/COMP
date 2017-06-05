package nodes;

import expression.BinaryOperator;
import expression.FieldRead;
import expression.Literal;
import expression.LocalVariableReference;
import expression.TypeAccess;
import expression.VariableRead;
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
			
			case "BinaryOperator":
				BinaryOperator binaryOp = (BinaryOperator) this;
				
				Expression lhsExp = binaryOp.getLhs();
				Expression rhsExp = binaryOp.getRhs();
				String op = binaryOp.getOperator();
				type = getTypeReference();
				
				String lhs = lhsExp.analyze();
				String rhs = rhsExp.analyze();
				
				System.out.println("BinaryOperator: " + lhs + " " + op + " " + rhs);
				
				String temp = rhs + " " + op + " " + rhs;
				retorno += temp;
				
				if(type != null) {
					type.analyze();
				}
				
				break;
			case "VariableRead":
				VariableRead varRead = (VariableRead) this;
				
				type = getTypeReference();
				Expression var = varRead.getVar();

				if(type != null)
					var.analyze();
				
				if(var != null)
					retorno = var.analyze();
				
				break;
			case "LocalVariableReference":
				LocalVariableReference localVarRef = (LocalVariableReference) this;
				
				String name = localVarRef.getName();
				type = getTypeReference();
				
				if(name != null)
					System.out.println("LocalVariableReference - Name: " + name);
				
				if(type != null)
					type.analyze();
				
				retorno = name;
				
				break;
			case "TypeAccess":
				TypeAccess typeAcc = (TypeAccess) this;
				
				Reference target = typeAcc.getTarget();
				type = getTypeReference();
				
				if(target != null)
					target.analyze();
				
				if(type != null)
					type.analyze();
				
				break;
			case "FieldRead":
				FieldRead fieldRead = (FieldRead) this;
				
				Expression targetFR = fieldRead.getTarget();
				Reference varFR = fieldRead.getVar();
				type = getTypeReference();
				
				if(targetFR != null)
					targetFR.analyze();
				
				if(varFR != null)
					varFR.analyze();
					
				if(type != null)
					type.analyze();
				break;
			default:
				System.out.println("Unsupported note type");
				break;

		}

		return retorno;
	}
}
