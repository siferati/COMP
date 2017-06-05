package nodes;

import java.util.List;

import nodes.BasicNode;
import reference.ArrayTypeReference;
import reference.ExecutableReference;
import reference.FieldReference;
import reference.Parameter;
import reference.TypeReference;
import main.*;

public class Reference extends BasicNode {
	private String name;

	public String getName() {
		return name;
	}

	  public String analyze(SimpleNode patternNode) {
	      // get initialization
	      String initString = "";

		  switch (getNodetype()) {
	      	case "ExecutableReference":
	      		ExecutableReference execRef = (ExecutableReference) this;
	      		Reference declarator = execRef.getDeclarator();
	      		Reference type = execRef.getType();
	      		List<Reference> parameters = execRef.getParameters();

	      		if(name != null)
	      			//System.out.println("ExecutableReference - Name: " + name);
	      		if(declarator != null)
	      			declarator.analyze(patternNode);
	      		if(type != null)
	      			type.analyze(patternNode);

		        //System.out.println("\n\tReference - Parameters:");
	      		for(int i = 0; i < parameters.size(); i++) {
	      			parameters.get(i).analyze(patternNode);
	      		}

	      		break;
	      	case "TypeReference":
	      		TypeReference typeRef = (TypeReference) this;

	      		if(name != null) {
							//System.out.println("TypeReference - Name: " + name);

						}

	      		String pkg = typeRef.getPackage();

	      		if (pkg != null) {
							//System.out.println("TypeReference - Package: " + pkg);

						}

	      		break;
	      	case "Parameter":
	      		Parameter param = (Parameter)this;
	      		name = getName();
	      		Reference typeReference = param.getType();

	      		if(name != null) {
							//System.out.println("Parameter - Name: " + name);
						}

	      		if(typeReference != null)
	      			typeReference.analyze(patternNode);

	      		break;
	      	case "ArrayTypeReference":
	      		ArrayTypeReference arrayTypeRef = (ArrayTypeReference) this;
	      		Reference typeArrayRef = arrayTypeRef.getType();
	      		name = getName();

	      		if(name != null)
	      			//System.out.println("ArrayTypeReference - Name: " + name);

	      		if(typeArrayRef != null) {
	      			typeArrayRef.analyze(patternNode);
	      		}

	      		break;
	      	case "FieldReference":
	      		FieldReference fieldRef = (FieldReference) this;
	      		name = getName();
	      		Reference decFieldRef = fieldRef.getDeclarator();
	      		Reference typeFieldRef = fieldRef.getType();

	      		if(decFieldRef != null)
	      			decFieldRef.analyze(patternNode);

	      		if(typeFieldRef != null)
	      			typeFieldRef.analyze(patternNode);

	      		break;
	      	default:
		        //System.out.println("Unsupported node type");
		        break;
		  }

		  return initString;
	  }
}
