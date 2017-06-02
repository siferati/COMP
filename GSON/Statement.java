public class Statement extends BasicNode {

  public void analyze() {

    switch (getNodetype()) {

      case "LocalVariable":
        LocalVariable localVariable = (LocalVariable) this;

        // get variable type (int, long, double, etc)
        String variableType = localVariable.getType().getName();

        // get variable name
        String variableName = localVariable.getName();

        // get initialization
        String initString = "";

        if (localVariable.getInit() != null) {
          initString += "= " + localVariable.getInit().analyze();

        }

        System.out.println(variableType + " " + variableName + " " + initString);
        break;

      default:
        System.out.println("Unsupported note type");
        break;
    }
  }
}
