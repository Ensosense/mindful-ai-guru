package se.enso.hokku.adapters.hokku;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import se.enso.hokku.domain.hokku.Hokku;
import se.enso.hokku.domain.hokku.ports.HokkuServicePort;

//api adapter
@Controller
@RequiredArgsConstructor
public class HokkuController {

  private final HokkuServicePort hokkuServicePort;

/*  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message, Model model) {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    model.addAttribute("hokku", hokku);
    return "hokku";
  }*/

  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message, Model model) {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    hokkuServicePort.saveHokkuToRedis(hokku);
    model.addAttribute("hokku", hokku);
    return "hokku";
  }

  @PostMapping("/hokku")
  public ResponseEntity<String> saveHokkuToRedis(@RequestBody Hokku hokku){
    boolean result = hokkuServicePort.saveHokkuToRedis(hokku);

    if(result)
      return ResponseEntity.ok("Hokku created successfully");
    else
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }


  @GetMapping("/hokku")
  public ResponseEntity<List<Hokku>> fetchAllHokkus(){
    List<Hokku> hokkus;
    hokkus = hokkuServicePort.fetchAllHokkus();

    return ResponseEntity.ok(hokkus);
  }
}
