package nodes;

import java.util.List;

import type.ClassNode;

public class Type extends BasicNode {
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public String analyze() {
	      // get initialization
	      String initString = "";
	      
		  switch (getNodetype()) {
	      	case "Class":
		        ClassNode classNode = (ClassNode) this;
		        
		        String pkg = classNode.getPackage();
		        List<Member> members = classNode.getMembers();
		        
		        if(name != null) {
		        	System.out.println("Class - Name: " + name);
		        }
		        
		        if(pkg != null) {
		        	System.out.println("Class - Package: " + pkg);
		        }
		        
		        System.out.println("\n\tMembers:");
		        for(int i = 0; i < members.size(); i++) {
		        	members.get(i).analyze();
		        }
		        break;
	      	default:
		        System.out.println("Unsupported Node Type");
		        break;
		  }
		  return initString;
	  }
}