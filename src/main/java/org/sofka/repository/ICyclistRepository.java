package org.sofka.repository;

import org.sofka.collection.Cyclist;
import org.sofka.dto.CyclistDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ICyclistRepository extends ReactiveCrudRepository<Cyclist,String> {
    Flux<List<CyclistDTO>> saveAll(List<CyclistDTO> cyclistDTOList);
}
