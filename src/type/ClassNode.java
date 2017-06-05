package type;
import com.google.gson.annotations.SerializedName;

import nodes.Member;
import nodes.Type;

import java.util.*;

public class ClassNode extends Type {
	@SerializedName("package") // usem esta anotacao quando a propriedade no JSON e uma palavra reservada. aqui para nao dar erro no Java digo que a minha variavel
	private String _package;	//chama-se "_package" MAS a propriedade que ele deve usar e mesmo "package"
	private List<Member> members;

	public String getPackage() {
		return _package;
	}

	public List<Member> getMembers() {
		return members;
	}
}
