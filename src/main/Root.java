package main;
import java.util.*;

import nodes.BasicNode;

public class Root extends BasicNode {
	private List<CompilationUnit> compilation_units;

	public List<CompilationUnit> getCompilationUnits() {
		return compilation_units;
	}
}
