package se.enso.hokku.domain.hokku.ports;

import java.util.List;
import se.enso.hokku.domain.hokku.Hokku;

//api port
public interface HokkuServicePort {
  Hokku getHokkuJson(String message);

  boolean saveHokkuToRedis(Hokku hokku);

  List<Hokku> fetchAllHokkus();
}
