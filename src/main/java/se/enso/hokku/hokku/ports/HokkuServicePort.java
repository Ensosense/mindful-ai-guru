package se.enso.hokku.hokku.ports;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.enso.hokku.hokku.Hokku;

// api port
public interface HokkuServicePort {
  Hokku getHokkuJson(String message);

  boolean saveHokkuToRedis(Hokku hokku);

  Flux<Hokku> fetchAllHokkus();

  Mono<Hokku> saveHokkuToFirestore(Hokku hokku);

  Flux<Hokku> getAllHokkus();
}
