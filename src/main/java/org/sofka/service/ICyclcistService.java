package org.sofka.service;

import org.sofka.dto.CyclistDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICyclcistService {

    /**
     * Crear Cyclista
     * @param cyclistDTO
     * @return Mono<CyclistDTO></>
     */
    Mono<CyclistDTO> createCyclist(CyclistDTO cyclistDTO);

    /**
     * Ver Cyclist
     * @param cyclistId
     * @return Mono<CyclistDTO></>
     */
    Mono<CyclistDTO> getCyclist(String cyclistId);

    /**
     * Listar Cyclist del equipo
     */
    Flux<CyclistDTO> listCyclist();
}
