package main;

import nodes.BasicNode;
import nodes.Type;

import java.util.*;

public class CompilationUnit extends BasicNode {
	private List<Type> types;

	public List<Type> getTypes() {
		return types;
	}
}
