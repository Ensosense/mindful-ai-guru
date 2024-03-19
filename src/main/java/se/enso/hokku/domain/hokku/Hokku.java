package se.enso.hokku.domain.hokku;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hokku {

  private String id;
  private String text;
  private String title;

  public Hokku() {
  }
}
