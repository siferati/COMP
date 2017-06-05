package nodes;
import java.util.List;

import nodes.BasicNode;
import reference.ExecutableReference;
import statement.*;
import main.*;

public class Statement extends BasicNode {

  public String analyze(SimpleNode patternNode) {

	  switch (getNodetype()) {
      	case "LocalVariable":
	        LocalVariable localVariable = (LocalVariable) this;

	        // get variable type (int, long, double, etc)
	        String variableType = localVariable.getType().getName();

	        // get variable name
	        String variableName = localVariable.getName();

          // when its NOT only declaration
	        if (localVariable.getInit() != null) {

            if (patternNode.getValue().toString().equals("=")) {

              // add operator = TODO fazer verificaçoes de tags iguais aqui
              Main.matchedNodes.add(new Match(patternNode.getValue().toString(), "=", localVariable.getLocation()));

              // add lhs
              SimpleNode lhs = (SimpleNode) patternNode.getChildren()[0];
              Main.matchedNodes.add(new Match(lhs.getValue().toString(), variableName, localVariable.getLocation()));

              // add rhs
              SimpleNode rhs = (SimpleNode) patternNode.getChildren()[1];
              Main.matchedNodes.add(new Match(rhs.getValue().toString(), localVariable.getInit().analyze(patternNode), localVariable.getLocation()));

              System.out.println("Found pattern " + lhs.getValue() + " = " + rhs.getValue() + " on line " +  localVariable.getLocation());
            }
	        }

	        //System.out.println(variableType + " " + variableName + " " + initString);
	        break;
      	case "Block":
      		Block block = (Block) this;

      		List<Statement> statements = block.getStatements();

	        //System.out.println("\n\tStatements:");
      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze(patternNode);
      		}

      		break;
      	case "Invocation":
      		Invocation invocation = (Invocation) this;
      		Reference ref = invocation.getExecutable();

      		if(ref != null) {
	      		ExecutableReference execRef = (ExecutableReference) ref;
	      		execRef.analyze(patternNode);
      		}

      		List<Expression> arguments = invocation.getArguments();

	        //System.out.println("\n\tArguments:");
      		for(int i = 0; i < arguments.size(); i++) {
      			arguments.get(i).analyze(patternNode);
      		}

      		break;
      	case "Comment":
      		Comment comment = (Comment) this;

      		String content = comment.getContent();
      		String position = comment.getPosition();
      		String type = comment.getType();

      		if(content != null)
      			//System.out.println("Comment - content: " + content);

      		if(position != null)
      			//System.out.println("Comment - position: " + position);

      		if(type != null)
      			//System.out.println("Comment - type: " + type);

      		break;
      	case "If":
      		If ifstatement = (If)this;

      		Expression cond = ifstatement.getCondition();
      		Statement then = ifstatement.getThen();
      		Statement elseVar = ifstatement.getElse();

      		if(cond != null)
      			cond.analyze(patternNode);

      		if(then != null)
      			then.analyze(patternNode);

      		if(elseVar != null && elseVar.getNodetype() != "NullNode")
      			elseVar.analyze(patternNode);

      		break;
      	case "Break":
      		break;
      	case "For":
      		For forstatement = (For)this;

      		Statement body = forstatement.getBody();
      		Expression condition = forstatement.getCondition();
      		List<Statement> init = forstatement.getInit();
      		List<Expression> update = forstatement.getUpdate();

      		if(body != null)
      			body.analyze(patternNode);

      		for(int i = 0; i < init.size(); i++)
      			init.get(i).analyze(patternNode);

      		if(condition != null)
      			condition.analyze(patternNode);

      		for(int i = 0; i < update.size(); i++)
      			update.get(i).analyze(patternNode);

      		break;
      	case "Switch":
      		Switch switchstmt = (Switch) this;

      		condition = switchstmt.getCondition();
      		List<Statement> cases = switchstmt.getCases();

      		for(int i = 0; i < cases.size(); i++) {
      			cases.get(i).analyze(patternNode);
      		}

      		break;
      	case "Case":
      		Case casestmt = (Case) this;

      		Expression expression = casestmt.getExpression();
      		statements = casestmt.getStatements();

      		if(expression != null)
      			expression.analyze(patternNode);

      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze(patternNode);
      		}

      		break;
		case "Assignment":
	        Assignment assignment = (Assignment) this;

	        // get variable type (int, long, double, etc)
	        variableType = assignment.getType().getName();

	        // get variable name
	        Expression lhsExp = assignment.getLhs();
			Expression rhsExp = assignment.getRhs();
			
			String lhs = lhsExp.analyze(patternNode);

          // when its NOT only declaration
	        if (rhsExp != null) {
				String rhs = rhsExp.analyze(patternNode);
				content = lhs + " = " + rhs;

				if (patternNode.getValue().toString().equals("=")) {
				  System.out.println("Found pattern on line " + assignment.getLocation());
				  Main.matchedNodes.add(new Match(patternNode.getValue().toString(), content, assignment.getLocation()));
				}
	        }
			break;
      	default:
	        //System.out.println("Unsupported Node Type");
	        break;
	  }
	  return "";
  }
 }
