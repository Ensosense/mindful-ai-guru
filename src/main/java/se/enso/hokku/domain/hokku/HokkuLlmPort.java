package se.enso.hokku.domain.hokku;

//spi port
public interface HokkuLlmPort {

  Hokku save(Hokku hokku);

  void deleteById(String hokkuId);

  Hokku generateHokkuJson(String message);
}