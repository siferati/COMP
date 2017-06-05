package nodes;
import java.util.List;

import nodes.BasicNode;
import reference.ExecutableReference;
import statement.*;

public class Statement extends BasicNode {

  public String analyze(String pattern) {
      // get initialization
      String initString = "";

	  switch (getNodetype()) {
      	case "LocalVariable":
	        LocalVariable localVariable = (LocalVariable) this;

	        // get variable type (int, long, double, etc)
	        String variableType = localVariable.getType().getName();

	        // get variable name
	        String variableName = localVariable.getName();

          // when its NOT only declaration
	        if (localVariable.getInit() != null) {
	          initString += "= " + localVariable.getInit().analyze(pattern);

            if (pattern.equals("=")) {
              System.out.println("Found pattern on line " + localVariable.getLocation());
            }
	        }

	        //System.out.println(variableType + " " + variableName + " " + initString);
	        break;
      	case "Block":
      		Block block = (Block) this;

      		List<Statement> statements = block.getStatements();

	        //System.out.println("\n\tStatements:");
      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze(pattern);
      		}

      		break;
      	case "Invocation":
      		Invocation invocation = (Invocation) this;
      		Reference ref = invocation.getExecutable();

      		if(ref != null) {
	      		ExecutableReference execRef = (ExecutableReference) ref;
	      		execRef.analyze(pattern);
      		}

      		List<Expression> arguments = invocation.getArguments();

	        //System.out.println("\n\tArguments:");
      		for(int i = 0; i < arguments.size(); i++) {
      			arguments.get(i).analyze(pattern);
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
      			cond.analyze(pattern);

      		if(then != null)
      			then.analyze(pattern);

      		if(elseVar != null && elseVar.getNodetype() != "NullNode")
      			elseVar.analyze(pattern);

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
      			body.analyze(pattern);

      		for(int i = 0; i < init.size(); i++)
      			init.get(i).analyze(pattern);

      		if(condition != null)
      			condition.analyze(pattern);

      		for(int i = 0; i < update.size(); i++)
      			update.get(i).analyze(pattern);

      		break;
      	case "Switch":
      		Switch switchstmt = (Switch) this;

      		condition = switchstmt.getCondition();
      		List<Statement> cases = switchstmt.getCases();

      		for(int i = 0; i < cases.size(); i++) {
      			cases.get(i).analyze("");
      		}

      		break;
      	case "Case":
      		Case casestmt = (Case) this;

      		Expression expression = casestmt.getExpression();
      		statements = casestmt.getStatements();

      		if(expression != null)
      			expression.analyze("");

      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze("");
      		}

      		break;
      	default:
	        //System.out.println("Unsupported Node Type");
	        break;
	  }
	  return initString;
  }
 }
