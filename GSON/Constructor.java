import java.util.*;

public class Constructor extends Member {
	private Statement body;
	private List<Parameter> parameters;
	
	public Statement getBody() {
		return body;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
}