public class LocalVariable extends Statement {
	private String name;
	private Reference type;
	private Expression init;
	
	public String getName() {
		return name;
	}
	
	public Reference getType() {
		return type;
	}
	
	public Expression getInit() {
		return init;
	}
}