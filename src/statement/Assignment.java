package statement;
import nodes.Expression;
import nodes.Reference;
import nodes.Statement;

public class Assignment extends Statement {
	private Reference type;
	private Expression lhs;
	private Expression rhs;
	
	public Reference getType() {
		return type;
	}
	public Expression getLhs() {
		return lhs;
	}
	public Expression getRhs() {
		return rhs;
	}	
}