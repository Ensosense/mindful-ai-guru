package se.enso.hokku.domain.hokku.ports;

import se.enso.hokku.domain.hokku.Hokku;

//spi port
public interface HokkuLlmPort {

  Hokku generateHokkuJson(String message);
}
