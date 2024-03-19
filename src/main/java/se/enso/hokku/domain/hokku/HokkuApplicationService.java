package se.enso.hokku.domain.hokku;

import lombok.RequiredArgsConstructor;
import se.enso.hokku.domain.utils.custom_annotations.DomainService;

@DomainService
@RequiredArgsConstructor
public class HokkuApplicationService implements HokkuServicePort {

  private final HokkuLlmPort hokkus;


  @Override
  public Hokku getHokkuJson(String message) {
    return hokkus.generateHokkuJson(message);
  }
}
