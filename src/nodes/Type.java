package nodes;

import java.util.List;

import type.ClassNode;

public class Type extends BasicNode {
	protected String name;

	public String getName() {
		return name;
	}

	public void analyze(String pattern) {

		  switch (getNodetype()) {
	      	case "Class":
		        ClassNode classNode = (ClassNode) this;

		        String pkg = classNode.getPackage();
		        List<Member> members = classNode.getMembers();

		        if(name != null) {
		        	//System.out.println("Class - Name: " + name);
		        }

		        if(pkg != null) {
		        	//System.out.println("Class - Package: " + pkg);
		        }

		        //System.out.println("\n\tMembers:");
		        for(int i = 0; i < members.size(); i++) {
		        	members.get(i).analyze(pattern);
		        }
		        break;
	      	default:
		        //System.out.println("Unsupported Node Type");
		        break;
		  }
	  }
}
