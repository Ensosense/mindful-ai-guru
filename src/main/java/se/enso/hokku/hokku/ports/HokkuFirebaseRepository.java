package se.enso.hokku.hokku.ports;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import se.enso.hokku.hokku.Hokku;

@Repository
public interface HokkuFirebaseRepository extends FirestoreReactiveRepository<Hokku> {

}
