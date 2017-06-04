package nodes;

import nodes.BasicNode;

public class Reference extends BasicNode {
	private String name;
	
	public String getName() {
		return name;
	}
	
	  public String analyze() {
	      // get initialization
	      String initString = "";
	      
		  switch (getNodetype()) {
	      	case "ExecutableReference":
	      		break;
	      	default:
		        System.out.println("Unsupported node type");
		        break;
		  }
		  
		  return initString;
	  }
}
