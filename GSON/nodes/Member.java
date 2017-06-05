package nodes;

import java.util.List;

import reference.Parameter;
import member.Constructor;
import member.Method;
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
				
				System.out.println("Constructor - Name: " + name);
				
				List<Reference> parameters = constructor.getParameters();
			
		        System.out.println("\n\tParameters:");
				for(int i = 0; i < parameters.size(); i++) {
					parameters.get(i).analyze();
				}
				
				Statement statement = constructor.getBody();			
				statement.analyze();
				break;
			case "Method":
				Method method = (Method)this;
				
				Statement body = method.getBody();
				name = getName();
				List<Reference> param = method.getParameters();
				Reference type = method.getType();
				
		        System.out.println("\n\tParameters:");
				for(int i = 0; i < param.size(); i++) {
					param.get(i).analyze();
				}
				
				if (type != null)
					type.analyze();
				
				if(name != null)
					System.out.println("Method - Name: " + name);
				
				if(body != null)
					body.analyze();
				
				break;
			default:
				System.out.println("Unsupported node type");
				break;
		}

		return retorno;
	}
}