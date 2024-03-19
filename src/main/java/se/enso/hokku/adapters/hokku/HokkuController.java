package se.enso.hokku.adapters.hokku;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.enso.hokku.domain.hokku.Hokku;
import se.enso.hokku.domain.hokku.HokkuServicePort;

//api adapter
@Controller
@RequiredArgsConstructor
public class HokkuController {

  private final ChatClient chatClient;
  private final HokkuServicePort hokkuServicePort;

  @GetMapping("/joke")
  public String completion(@RequestParam(value = "message", defaultValue = "Tell me a joke about cats, not same as previous") String message) {
    Object result = chatClient.call(message);
    System.out.println(result);
    return result.toString();
  }

  @GetMapping("/json-hokku")
  public String getHokkuJson(@RequestParam(value = "theme", defaultValue = "zen") String message, Model model)
      throws JsonProcessingException {
    Hokku hokku = hokkuServicePort.getHokkuJson(message);
    model.addAttribute("hokku", hokku);
    return "hokku"; // This is the name of the Thymeleaf template file (json-hokku.html)
  }
}
