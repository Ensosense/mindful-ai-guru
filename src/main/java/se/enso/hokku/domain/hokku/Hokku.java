package se.enso.hokku.domain.hokku;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hokku implements Serializable {

  private String id;
  private String text;
  private String title;

  public Hokku() {
  }
}
