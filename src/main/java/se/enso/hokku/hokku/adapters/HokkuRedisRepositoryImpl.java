package se.enso.hokku.hokku.adapters;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import se.enso.hokku.hokku.Hokku;
import se.enso.hokku.hokku.ports.HokkuRedisRepository;

//spi adapter
@Repository
public class HokkuRedisRepositoryImpl implements HokkuRedisRepository {

  @Autowired
  private RedisTemplate redisTemplate;


  private static final String KEY = "hokku";
  @Override
  public boolean saveHokku(Hokku hokku) {
    return true;
  }

  @Override
  public Flux<Hokku> fetchAllHokkus() {
    List<Hokku> hokkusList = redisTemplate.opsForHash().values(KEY);
    return Flux.fromIterable(hokkusList);
  }


}
