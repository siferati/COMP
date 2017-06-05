import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import nodes.BasicNode;
import expression.BinaryOperator;
import expression.Literal;
import expression.LocalVariableReference;
import expression.VariableRead;
import member.Constructor;
import member.Method;
import reference.ArrayTypeReference;
import reference.ExecutableReference;
import reference.Parameter;
import reference.TypeReference;
import statement.Block;
import statement.Comment;
import statement.LocalVariable;
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
		}
		return jsonDeserializationContext.deserialize(jsonElement, classToUse); // automatic desearialization.
		} catch(Exception e) {
			throw new JsonParseException(e);
		}
	}

}
