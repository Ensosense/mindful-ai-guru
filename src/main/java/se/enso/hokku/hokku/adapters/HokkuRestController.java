package se.enso.hokku.hokku.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import se.enso.hokku.hokku.Hokku;
import se.enso.hokku.hokku.ports.HokkuLlmPort;
import se.enso.hokku.hokku.ports.HokkuServicePort;

//api adapter
@RestController
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


  @GetMapping("/hokku")
  public Flux<Hokku> fetchAllHokkus() {
   return hokkuServicePort.fetchAllHokkus();
  }

  @PostMapping("/hokku")
  public Hokku generateHokku(
      @RequestParam(value = "theme", defaultValue = "zen") String message) {
    Hokku hokku = hokkuLlmPort.generateHokkuJson(message);
    hokkuServicePort.saveHokkuToFirestore(hokku);
    hokkuServicePort.saveHokkuToRedis(hokku);
    System.out.println(hokku);
    return hokku;
  }
}
