package main;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import nodes.BasicNode;
import expression.Assignment;
import expression.BinaryOperator;
import expression.FieldRead;
import expression.Literal;
import expression.LocalVariableReference;
import expression.NullNode;
import expression.TypeAccess;
import expression.UnaryOperator;
import expression.VariableRead;
import expression.VariableWrite;
import member.Constructor;
import member.Method;
import reference.ArrayTypeReference;
import reference.ExecutableReference;
import reference.FieldReference;
import reference.Parameter;
import reference.TypeReference;
import statement.Block;
import statement.Break;
import statement.Comment;
import statement.For;
import statement.If;
import statement.OperatorAssignment;
import statement.LocalVariable;
import statement.Switch;
import statement.Case;
import type.ClassNode;
import statement.Invocation;

import java.lang.reflect.Type;

public class MyNodeDeserializer implements JsonDeserializer<BasicNode> {
 @Override
	public BasicNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
		try {
			JsonObject jsonObj = jsonElement.getAsJsonObject();  // vao buscar o objeto atual como um JsonObject para poderem ir buscar a propriedade que querem
			JsonElement nodeTypeEl = jsonObj.get("nodetype"); 	 // get the type of the node so we can use the correct class
			if (nodeTypeEl == null) {
				throw new RuntimeException("nodetype property must be defined!"); // all JSON objects must have the property nodetype
		}
		String nodeType = nodeTypeEl.getAsString().toUpperCase(); // simply casting the object as string

		//System.out.println("NODETYPE " + nodeType);
		Class<? extends BasicNode> classToUse = null;
		switch(nodeType) {
			case "TYPEREFERENCE":
				classToUse = TypeReference.class;
				break;
			case "BINARYOPERATOR":
				classToUse = BinaryOperator.class;
				break;
			case "LITERAL":
				classToUse = Literal.class;
				break;
			case "VARIABLEREAD":
				classToUse = VariableRead.class;
				break;
			case "LOCALVARIABLEREFERENCE":
				classToUse = LocalVariableReference.class;
				break;
			case "BLOCK":
				classToUse = Block.class;
				break;
			case "CLASS":
				classToUse = ClassNode.class;
				break;
			case "CONSTRUCTOR":
				classToUse = Constructor.class;
				break;
			case "EXECUTABLEREFERENCE":
				classToUse = ExecutableReference.class;
				break;
			case "INVOCATION":
				classToUse = Invocation.class;
				break;
			case "LOCALVARIABLE":
				classToUse = LocalVariable.class;
				break;
			case "METHOD":
				classToUse = Method.class;
				break;
			case "PARAMETER":
				classToUse = Parameter.class;
				break;
			case "ROOT":
				classToUse = Root.class;
				break;
			case "COMPILATIONUNIT":
				classToUse = CompilationUnit.class;
				break;
			case "ARRAYTYPEREFERENCE":
				classToUse = ArrayTypeReference.class;
				break;
			case "COMMENT":
				classToUse = Comment.class;
				break;
			case "IF":
				classToUse = If.class;
				break;
			case "FIELDREAD":
				classToUse = FieldRead.class;
				break;
			case "TYPEACCESS":
				classToUse = TypeAccess.class;
				break;
			case "NULLNODE":
				classToUse = NullNode.class;
				break;
			case "FIELDREFERENCE":
				classToUse = FieldReference.class;
				break;
			case "VARIABLEWRITE":
				classToUse = VariableWrite.class;
				break;
			case "FOR":
				classToUse = For.class;
				break;
			case "BREAK":
				classToUse = Break.class;
				break;
			case "UNARYOPERATOR":
				classToUse = UnaryOperator.class;
				break;
			case "SWITCH":
				classToUse = Switch.class;
				break;
			case "CASE":
				classToUse = Case.class;
				break;
			case "OPERATORASSIGNMENT":
				classToUse = OperatorAssignment.class;
				break;
			case "ASSIGNMENT":
				classToUse = Assignment.class;
				break;
		}
			return jsonDeserializationContext.deserialize(jsonElement, classToUse); // automatic desearialization.
		} catch(Exception e) {
			throw new JsonParseException(e);
		}
	}

}
