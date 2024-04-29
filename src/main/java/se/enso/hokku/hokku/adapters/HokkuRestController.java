package se.enso.hokku.hokku.adapters;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.enso.hokku.hokku.Hokku;
import se.enso.hokku.hokku.ports.HokkuLlmPort;
import se.enso.hokku.hokku.ports.HokkuServicePort;

// api adapter
@RestController
@RequestMapping("/hokku")
@RequiredArgsConstructor
public class HokkuRestController {

  private final HokkuServicePort hokkuServicePort;
  private final HokkuLlmPort hokkuLlmPort;

  /*  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message, Model model) {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    model.addAttribute("hokku", hokku);
    return "hokku";
  }*/

  /*  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message,
                             Model model) {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    hokkuServicePort.saveHokkuToRedis(hokku);
    model.addAttribute("hokku", hokku);
    return "hokku";
  }*/

  /*  @PostMapping("/hokku")
  Mono<Hokku> createHokku(@RequestBody Hokku hokku) {
    hokkuServicePort.saveHokkuToRedis(hokku);
    return hokkuServicePort.saveHokkuToFirestore(hokku);
  }*/

  @GetMapping()
  public Flux<Hokku> fetchAllHokkus() {
    return hokkuServicePort.getAllHokkus();
  }

 /* @PostMapping()
  public Hokku generateHokku(@RequestParam(value = "theme", defaultValue = "zen") String message) {
    Hokku hokku = hokkuLlmPort.generateHokkuJson(message);
    Firestore db = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> result = db.collection("hokku").document().set(hokku);

    ApiFutures.addCallback(result, new ApiFutureCallback<WriteResult>() {
      @Override
      public void onFailure(Throwable throwable) {
        System.err.println("Error writing document: " + throwable.getMessage());
      }

      @Override
      public void onSuccess(WriteResult writeResult) {
        System.out.println("Haiku successfully written!");
      }
    });

    hokkuServicePort.saveHokkuToFirestore(hokku);
    System.out.println(hokku);
    return hokku;
  }*/
 @PostMapping()
 public Mono<Hokku> generateHokku(@RequestParam(value = "theme", defaultValue = "zen") String theme) {
   Hokku hokku = hokkuLlmPort.generateHokkuJson(theme);
   Firestore db = FirestoreClient.getFirestore();
   DocumentReference docRef = db.collection("hokku").document();
   hokku.setId(docRef.getId());
   ApiFuture<WriteResult> result = docRef.set(hokku);

    return Mono.fromFuture(() -> CompletableFuture.completedFuture(result))
       .thenReturn(hokku)
        .doOnSuccess(writeResult -> {
          System.out.println("Hokku successfully written with ID: " + hokku.getId());
        })
       .doOnError(error -> System.err.println("Error writing document: " + error.getMessage()));
 }

}
