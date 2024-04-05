package se.enso.hokku.hokku.ports;

import se.enso.hokku.hokku.Hokku;

//spi port
public interface HokkuLlmPort {

  Hokku generateHokkuJson(String message);
}
