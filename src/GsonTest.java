/**
* Copyright 2017 SPeCS.
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
* an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
* specific language governing permissions and limitations under the License. under the License.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import nodes.BasicNode;
import member.Method;
import nodes.Expression;
import nodes.Member;
import nodes.Reference;
import nodes.Statement;
import nodes.Type;
import statement.Block;
import type.ClassNode;

public class GsonTest {

  final public static String DEFAULT_CHAR_SET = "UTF-8";
  public Root javaRootMapObject;

  public GsonTest() {
    MyNodeDeserializer typeAdapter = new MyNodeDeserializer();
    Gson gson = new GsonBuilder()
    .registerTypeAdapter(BasicNode.class, typeAdapter)
    .registerTypeAdapter(Reference.class, typeAdapter)
    .registerTypeAdapter(Expression.class, typeAdapter)
    .registerTypeAdapter(Type.class, typeAdapter)
    .registerTypeAdapter(Member.class, typeAdapter)
    .registerTypeAdapter(Statement.class, typeAdapter)
    .create();

    File json = new File("ast.json");

    javaRootMapObject = gson.fromJson(read(json), Root.class);

  }


  /**
  * Given a File object, returns a String with the contents of the file.
  *
  * <p>
  * If an error occurs (ex.: the File argument does not represent a file) returns null and logs the cause.
  *
  * @param file
  *            a File object representing a file.
  * @return a String with the contents of the file.
  */
  public static String read(File file) {
    // Check null argument. If null, it would raise and exception and stop
    // the program when used to create the File object.
    if (file == null) {
      Logger.getLogger("info").info("Input 'file' is null.");
      return null;
    }

    StringBuilder stringBuilder = new StringBuilder();

    // Try to read the contents of the file into the StringBuilder

    try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
    DEFAULT_CHAR_SET))) {

      // Read first character. It can't be cast to "char", otherwise the
      // -1 will be converted in a character.
      // First test for -1, then cast.
      int intChar = bufferedReader.read();
      while (intChar != -1) {
        char character = (char) intChar;
        stringBuilder.append(character);
        intChar = bufferedReader.read();
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger("info").info("FileNotFoundException: " + ex.getMessage());
      return null;

    } catch (IOException ex) {
      Logger.getLogger("info").info("IOException: " + ex.getMessage());
      return null;
    }

    return stringBuilder.toString();
  }


  /**
  * Goes through the Root and all of its children to analyze it
  *
  * @param javaRootMapObject Tree root
  */
  public void analyze(Root javaRootMapObject, String pattern) {

    List<CompilationUnit> compilationUnits = javaRootMapObject.getCompilationUnits();

    // there is only one compilation unit
    List<Type> types = compilationUnits.get(0).getTypes();

    for(int i = 0; i < types.size(); i++) {
    	types.get(i).analyze(pattern);
    }
  }
}
