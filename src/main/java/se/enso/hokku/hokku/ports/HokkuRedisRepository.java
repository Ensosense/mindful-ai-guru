package se.enso.hokku.hokku.ports;

import reactor.core.publisher.Flux;
import se.enso.hokku.hokku.Hokku;

// spi port
public interface HokkuRedisRepository {

  boolean saveHokku(Hokku hokku);

  Flux<Hokku> fetchAllHokkus();
}
