package se.enso.hokku.hokku.ports;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import se.enso.hokku.hokku.Hokku;

public interface HokkuFirebaseRepository extends FirestoreReactiveRepository<Hokku> {}
