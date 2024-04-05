package se.enso.hokku.hokku.adapters;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.enso.hokku.hokku.Hokku;
import se.enso.hokku.hokku.ports.HokkuServicePort;

@Controller
@RequiredArgsConstructor
public class HokkuController {

  private final HokkuServicePort hokkuServicePort;

  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message,
                             Model model) {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    model.addAttribute("hokku", hokku);
    return "index";

  }
}
