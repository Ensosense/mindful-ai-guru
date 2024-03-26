package se.enso.hokku.domain.hokku;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import se.enso.hokku.domain.hokku.ports.HokkuLlmPort;
import se.enso.hokku.domain.hokku.ports.HokkuRepository;
import se.enso.hokku.domain.hokku.ports.HokkuServicePort;
import se.enso.hokku.domain.utils.custom_annotations.DomainService;

@DomainService
@RequiredArgsConstructor
public class HokkuApplicationService implements HokkuServicePort {

  @Autowired
  private final HokkuLlmPort hokkuLlmPort;

  @Autowired
  private final HokkuRepository hokkuRepository;


  @Override
  public Hokku getHokkuJson(String message) {
    return hokkuLlmPort.generateHokkuJson(message);
  }

  @Override
  public boolean saveHokkuToRedis(Hokku hokku) {
    return hokkuRepository.saveHokku(hokku);
  }

  @Override
  public List<Hokku> fetchAllHokkus() {
    return hokkuRepository.fetchAllUsers();
  }
}
