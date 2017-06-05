package reference;

import nodes.Reference;

public class FieldReference extends Reference {
	private Reference declarator;
	private Reference type;
	
	public Reference getDeclarator() {
		return declarator;
	}
	
	public Reference getType() {
		return type;
	}
}