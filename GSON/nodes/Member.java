package nodes;

import java.util.List;

import reference.Parameter;
import expression.Literal;
import member.Constructor;
import nodes.BasicNode;

public class Member extends BasicNode {
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public String analyze() {

		String retorno = "";

		switch (getNodetype()) {
			case "Constructor":
				Constructor constructor = (Constructor) this;
				
				String name = constructor.getName();
				
				System.out.println("(Class -> Constructor) - Name: " + name);
				
				List<Parameter> parameters = constructor.getParameters();
				
				for(int i = 0; i < parameters.size(); i++) {
					parameters.get(i).analyze();
				}
				
				Statement statement = constructor.getBody();			
				statement.analyze();
				break;
			case "Method":
				
				break;
			default:
				System.out.println("Unsupported node type");
				break;
		}

		return retorno;
	}
}