package se.enso.hokku.hokku.adapters;


import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.enso.hokku.hokku.Hokku;
import se.enso.hokku.hokku.ports.HokkuLlmPort;

// spi adapter
@Component
@RequiredArgsConstructor
public class HokkuLlmAdapter implements HokkuLlmPort {

  @Autowired
  OpenAiChatClient chatClient;

  @Override
  public Hokku generateHokkuJson(String message) {
    var outputParser = new BeanOutputParser<>(Hokku.class);

    String userMessage =
        """
            Generate a haiku in a classical japanese style for the {theme} theme {format}
            """;

    PromptTemplate promptTemplate = new PromptTemplate(userMessage,
        Map.of("theme", message, "format", outputParser.getFormat()));
    Prompt prompt = promptTemplate.create();
    Generation generation = chatClient.call(prompt).getResult();


   // System.out.println(generation.getOutput().getContent());
    return outputParser.parse(generation.getOutput().getContent());
  }

}
