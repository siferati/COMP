import com.google.gson.annotations.SerializedName;
import java.util.*;

public class ClassNode extends Type {
	@SerializedName("package") // usem esta anota��o quando a propriedade no JSON � uma palavra reservada. aqui para n�o dar erro no Java digo que a minha vari�vel
	private String _package;	//chama-se "_package" MAS a propriedade que ele deve usar � mesmo "package"
	private List<Member> members;
	
	public String getPackage() {
		return _package;
	}
	
	public List<Member> getMembers() {
		return members;
	}
}