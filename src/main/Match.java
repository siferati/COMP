package main;

public class Match {

  public String pattern;
  public String content;
  public String location;

  public Match(String pattern, String content, String location) {
    this.pattern = pattern;
    this.content = content;
    this.location = location;
  }

  @Override
  public String toString() {
    return pattern + " : " + content + " : " + location;
  }


}
