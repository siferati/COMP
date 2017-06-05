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
import main.*;

public class Expression extends BasicNode {
	public String analyze(SimpleNode patternNode) {

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

				String lhsStr = lhsExp.analyze(patternNode);

				String rhsStr = rhsExp.analyze(patternNode);

				// add lhs
				SimpleNode lhs = (SimpleNode) patternNode.getChildren()[0];
				Main.matchedNodes.add(new Match(lhs.getValue().toString(), lhsStr, binaryOp.getLocation()));

				// add rhs
				SimpleNode rhs = (SimpleNode) patternNode.getChildren()[1];
				Main.matchedNodes.add(new Match(rhs.getValue().toString(), rhsStr, binaryOp.getLocation()));

				//System.out.println("BinaryOperator: " + lhs + " " + op + " " + rhs);

				String temp = lhsStr + " " + op + " " + rhsStr;
				retorno += temp;

				if(type != null) {
					type.analyze(patternNode);
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

				String res = operand.analyze(patternNode);
				//System.out.println("UnaryOperator: " + res + tmpOp);

				temp = res + tmpOp;
				retorno += temp;

				break;
			case "VariableRead":
				VariableRead varRead = (VariableRead) this;

				type = varRead.getTypeReference();
				Expression var = varRead.getVar();

				if(type != null)
					var.analyze(patternNode);

				if(var != null)
					retorno = var.analyze(patternNode);

				break;
			case "LocalVariableReference":
				LocalVariableReference localVarRef = (LocalVariableReference) this;

				String name = localVarRef.getName();
				type = localVarRef.getTypeReference();

				if(name != null)
					//System.out.println("LocalVariableReference - Name: " + name);

				if(type != null)
					type.analyze(patternNode);

				retorno = name;

				break;
			case "TypeAccess":
				TypeAccess typeAcc = (TypeAccess) this;

				Reference target = typeAcc.getTarget();
				type = typeAcc.getTypeReference();

				if(target != null)
					target.analyze(patternNode);

				if(type != null)
					type.analyze(patternNode);

				break;
			case "FieldRead":
				FieldRead fieldRead = (FieldRead) this;

				Expression targetFR = fieldRead.getTarget();
				Reference varFR = fieldRead.getVar();
				type = fieldRead.getTypeReference();

				if(targetFR != null)
					targetFR.analyze(patternNode);

				if(varFR != null)
					varFR.analyze(patternNode);

				if(type != null)
					type.analyze(patternNode);
				break;
			case "VariableWrite":
				VariableWrite variableWrite = (VariableWrite) this;

				Expression varVW = variableWrite.getVar();
				type = variableWrite.getTypeReference();

				if(varVW != null)
					retorno = varVW.analyze(patternNode);

				if(type != null)
					type.analyze(patternNode);

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
