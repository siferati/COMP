package nodes;
import java.util.List;

import nodes.BasicNode;
import reference.ExecutableReference;
import statement.*;

public class Statement extends BasicNode {

  public String analyze() {
      // get initialization
      String initString = "";
      
	  switch (getNodetype()) {
      	case "LocalVariable":
	        LocalVariable localVariable = (LocalVariable) this;
	
	        // get variable type (int, long, double, etc)
	        String variableType = localVariable.getType().getName();
	
	        // get variable name
	        String variableName = localVariable.getName();
	
	        if (localVariable.getInit() != null) {
	          initString += "= " + localVariable.getInit().analyze();
	        }
	
	        System.out.println(variableType + " " + variableName + " " + initString);
	        break;
      	case "Block":
      		Block block = (Block) this;
      		
      		List<Statement> statements = block.getStatements();
      		
	        System.out.println("\n\tStatements:");
      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze();
      		}
      		
      		break;
      	case "Invocation":
      		Invocation invocation = (Invocation) this;
      		Reference ref = invocation.getExecutable();
      		
      		if(ref != null) {	      		
	      		ExecutableReference execRef = (ExecutableReference) ref;
	      		execRef.analyze();
      		}
      		
      		List<Expression> arguments = invocation.getArguments();
      		
	        System.out.println("\n\tArguments:");
      		for(int i = 0; i < arguments.size(); i++) {
      			String res = arguments.get(i).analyze();
      			
      			if(res != null) {
      				System.out.println("Argument " + i + " - Value: " + res);
      			}
      		}
      		      		
      		break;
      	case "Comment":   		
      		Comment comment = (Comment) this;
      		
      		String content = comment.getContent();
      		String position = comment.getPosition();
      		String type = comment.getType();
      		
      		if(content != null)
      			System.out.println("Comment - content: " + content);
      		
      		if(position != null)
      			System.out.println("Comment - position: " + position);
      		
      		if(type != null)
      			System.out.println("Comment - type: " + type);
      		
      		break;
      	case "If":
      		If ifstatement = (If)this;
      		
      		Expression cond = ifstatement.getCondition();
      		Statement then = ifstatement.getThen();
      		Statement elseVar = ifstatement.getElse();
      		
      		if(cond != null)
      			cond.analyze();
      		
      		if(then != null)
      			then.analyze();
      		
      		if(elseVar != null && elseVar.getNodetype() != "NullNode")
      			elseVar.analyze();
      		
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
      			body.analyze();
      		
      		for(int i = 0; i < init.size(); i++)
      			init.get(i).analyze();
      		
      		if(condition != null)
      			condition.analyze();
      		
      		for(int i = 0; i < update.size(); i++)
      			update.get(i).analyze();
      		
      		break;
      	case "Switch":
      		Switch switchstmt = (Switch) this;
      		
      		condition = switchstmt.getCondition();
      		List<Statement> cases = switchstmt.getCases();
      		
      		for(int i = 0; i < cases.size(); i++) {
      			cases.get(i).analyze();
      		}
      		
      		break;
      	case "Case":
      		Case casestmt = (Case) this;
      		
      		Expression expression = casestmt.getExpression();
      		statements = casestmt.getStatements();
      		
      		if(expression != null)
      			expression.analyze();
      		
      		for(int i = 0; i < statements.size(); i++) {
      			statements.get(i).analyze();
      		}
      		
      		break;
      	default:
	        System.out.println("Unsupported Node Type");
	        break;
	  }
	  return initString;
  }
 }
