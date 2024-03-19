package se.enso.hokku.adapters.hokku;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.enso.hokku.domain.hokku.Hokku;
import se.enso.hokku.domain.hokku.ports.HokkuServicePort;

//api adapter
@Controller
@RequiredArgsConstructor
public class HokkuController {

  private final HokkuServicePort hokkuServicePort;

  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message, Model model)
      throws JsonProcessingException {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    model.addAttribute("hokku", hokku);
    return "hokku";
  }
}
