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

	public void analyze(String pattern) {

		switch (getNodetype()) {
			case "Constructor":
				Constructor constructor = (Constructor) this;

				String name = constructor.getName();

				//System.out.println("Constructor - Name: " + name);

				List<Reference> parameters = constructor.getParameters();

		        //System.out.println("\n\tParameters:");
				for(int i = 0; i < parameters.size(); i++) {
					parameters.get(i).analyze(pattern);
				}

				Statement statement = constructor.getBody();
				statement.analyze(pattern);
				break;
			case "Method":
				Method method = (Method)this;

				Statement body = method.getBody();
				name = getName();
				List<Reference> param = method.getParameters();
				Reference type = method.getType();

		        //System.out.println("\n\tParameters:");
				for(int i = 0; i < param.size(); i++) {
					param.get(i).analyze(pattern);
				}

				if (type != null)
					type.analyze(pattern);

				if(name != null)
					//System.out.println("Method - Name: " + name);

				if(body != null)
					body.analyze(pattern);

				break;
			default:
				//System.out.println("Unsupported node type");
				break;
		}
	}
}
