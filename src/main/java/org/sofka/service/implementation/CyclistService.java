package org.sofka.service.implementation;

import org.sofka.dto.CyclistDTO;
import org.sofka.repository.ICyclistRepository;
import org.sofka.service.ICyclcistService;
import org.sofka.util.mapper.CyclistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CyclistService implements ICyclcistService {
    /**
     * Se inyecta el repositorio de ciclista
     */
    @Autowired
    private ICyclistRepository cyclistRepository;

    /**
     * Se inyecta el ciclista mapper
     */
    private CyclistMapper cyclistMapper;

    public CyclistService(){
        this.cyclistMapper = new CyclistMapper();
    }

    /**
     *
     * @param cyclistDTO
     * @return
     */
    @Override
    public Mono<CyclistDTO> createCyclist(CyclistDTO cyclistDTO) {
        return cyclistRepository
                .save(cyclistMapper
                        .fromCyclistDTOToCyclist()
                        .apply(cyclistDTO))
                .map(cyclistMapper.fromCyclistToCyclistDTO());
    }

    @Override
    public Mono<CyclistDTO> getCyclist(String cyclistId) {
        return cyclistRepository
                .findById(cyclistId)
                .map(cyclistMapper.fromCyclistToCyclistDTO());
    }

    @Override
    public Flux<CyclistDTO> listCyclist() {
        return cyclistRepository
                .findAll()
                .map(cyclist -> cyclistMapper.fromCyclistToCyclistDTO().apply(cyclist));
    }
}
