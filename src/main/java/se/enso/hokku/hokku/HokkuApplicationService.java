package se.enso.hokku.hokku;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.enso.hokku.hokku.ports.HokkuFirebaseRepository;
import se.enso.hokku.hokku.ports.HokkuLlmPort;
import se.enso.hokku.hokku.ports.HokkuRedisRepository;
import se.enso.hokku.hokku.ports.HokkuServicePort;
import se.enso.hokku.utils.custom_annotations.DomainService;

@DomainService
@RequiredArgsConstructor
public class HokkuApplicationService implements HokkuServicePort {

  @Autowired private final HokkuLlmPort hokkuLlmPort;

  @Autowired private final HokkuRedisRepository hokkuRedisRepository;

  @Autowired private final HokkuFirebaseRepository hokkuFirebaseRepository;

  @Override
  public Hokku getHokkuJson(String message) {
    return hokkuLlmPort.generateHokkuJson(message);
  }

  @Override
  public boolean saveHokkuToRedis(Hokku hokku) {
    return hokkuRedisRepository.saveHokku(hokku);
  }

  @Override
  public Flux<Hokku> fetchAllHokkus() {
    return hokkuRedisRepository.fetchAllHokkus();
  }

  @Override
  public Mono<Hokku> saveHokkuToFirestore(Hokku hokku) {
    return hokkuFirebaseRepository.save(hokku);
  }

  @Override
  public Flux<Hokku> getAllHokkus() {
    return hokkuFirebaseRepository.findAll();
  }
}
