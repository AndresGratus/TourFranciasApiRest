package org.sofka.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.sofka.dto.CyclistDTO;
import org.sofka.service.implementation.CyclistService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cyclist")
public class CyclistController {
    /**
     * Se inyecta el servicio de ciclista
     */
    private CyclistService cyclistService;

    /**
     * Endpoint para crear cyclista
     *
     * @param cyclistDTO
     * @return Mono<ResponseEntity <Mono < CyclistDTO></></Mono>></></ResponseEntity>></>
     */

    @Operation(summary = "---> Endpoint que nos permite crear un cyclista")
    @ApiResponse(responseCode = "200", description = "Se crea el ciclista")
    @PostMapping("/createCyclist")
    public Mono<ResponseEntity<Mono<CyclistDTO>>> createCyclist(@RequestBody CyclistDTO cyclistDTO){
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cyclistService.createCyclist(cyclistDTO))
            );
        } catch (Exception e){
            throw new RuntimeException("No se pudó crear un ciclista");
        }
    }

    /**
     *Endpoint para ver ciclista
     *
     * @param cyclisId
     * @return Mono<ResponseEntity<Mono<CyclistDTO>>></CyclistDTO>
     */
    @Operation(summary = "---> Endpoint que nos permite ver los ciclistas")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el ciclista")
    @GetMapping("/get/{cyclistId}")
    public Mono<ResponseEntity<Mono<CyclistDTO>>> getCyclistById(@PathVariable("cyclistId") String cyclisId){
        try {
            return  Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cyclistService.getCyclist(cyclisId))
            );
        } catch (Exception e){
            throw new RuntimeException("No se puede obtener el ciclista por el id");
        }
    }


    /**
     * Endpoint par alistar los ciclistas
     *
     * @return Mono<ResponseEntity <Flux <CyclistDTO>>></CyclistDTO>
     */
    @Operation(summary = "---> Endpoint que nos permite listar los cyclistas")
    @ApiResponse(responseCode = "200", description = "Se listaron los ciclistas")
    @GetMapping("/listCyclist")
    public  Mono<ResponseEntity<Flux<CyclistDTO>>> listaAllCyclist(){
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cyclistService.listCyclist())
            );
        } catch (Exception e){
            throw new RuntimeException("No se pudo listar los ciclistas");
        }
    }

}
