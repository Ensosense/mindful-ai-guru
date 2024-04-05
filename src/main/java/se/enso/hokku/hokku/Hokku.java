package se.enso.hokku.hokku;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collectionName = "hokku")
public class Hokku implements Serializable {

  @DocumentId
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String id;
  private String text;
  private String title;

}
