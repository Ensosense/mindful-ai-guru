package se.enso.hokku.haiku;

public class Haiku {

  private int id;
  private String title;
  private String text;

  public Haiku(int id, String title, String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public Haiku() {}

  public int getId(int id) {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle(String title) {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
