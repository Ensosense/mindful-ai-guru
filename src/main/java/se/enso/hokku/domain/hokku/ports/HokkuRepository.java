package se.enso.hokku.domain.hokku.ports;

import java.util.List;
import org.springframework.stereotype.Repository;
import se.enso.hokku.domain.hokku.Hokku;


//spi port
public interface HokkuRepository {

  boolean saveHokku(Hokku hokku);

  List<Hokku> fetchAllUsers();
}
