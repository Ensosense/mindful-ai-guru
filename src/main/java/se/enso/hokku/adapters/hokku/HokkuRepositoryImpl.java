package se.enso.hokku.adapters.hokku;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import se.enso.hokku.domain.hokku.Hokku;
import se.enso.hokku.domain.hokku.ports.HokkuRepository;

//spi adapter
@Repository
public class HokkuRepositoryImpl implements HokkuRepository {

  @Autowired
  private RedisTemplate redisTemplate;

  private static final String KEY = "hokku";
  @Override
  public boolean saveHokku(Hokku hokku) {
    try {
      redisTemplate.opsForHash().put(KEY, hokku.getId().toString(), hokku);
      return true;
    } catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Hokku> fetchAllUsers() {
    List<Hokku> hokkus;
    hokkus = redisTemplate.opsForHash().values(KEY);
    return hokkus;
  }
}
