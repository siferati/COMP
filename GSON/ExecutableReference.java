import java.util.*;

public class ExecutableReference extends Reference {
	private Reference declarator;
	private Reference type;
	private List<Parameter> parameters;
	
	public Reference getDeclarator() {
		return declarator;
	}
	
	public Reference getType() {
		return type;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
}