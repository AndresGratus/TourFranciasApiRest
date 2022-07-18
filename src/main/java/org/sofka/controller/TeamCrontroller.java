package org.sofka.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.sofka.dto.TeamDTO;
import org.sofka.service.implementation.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
@RequestMapping(value ="api/team")
public class TeamCrontroller {

    /**
     * Se inyecta el servicio
     */
    @Autowired
    private TeamService teamService;


    /**
     * Endpoin para crear un course
     *
      * @param teamDTO
     * @return Mono<ResponseEntity <Mono <TeamDTO></TeamDTO>>></TeamDTO>></>
     */
    @Operation(summary = "---> Endpoint que nos permite crear un equipo")
    @ApiResponse(responseCode = "200", description = "Se crea el equipo")
    @PostMapping("api/create")
    public Mono<ResponseEntity<Mono<TeamDTO>>> createTeam(@RequestBody TeamDTO teamDTO){
        try{
            return  Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.createTeam(teamDTO))
            );
        } catch(Exception e){
            throw new RuntimeException("No se pudo crear el programa");
        }
    }

    /**
     * Enpoin para obtener un Team for id
     *
     * @param teamId
     * @return Mono<ResponseEntity<Mono<TeamDTO></TeamDTO></Mono>></Mono>></ResponseEntity>
     */
    @Operation(summary = "---> Endpoint que nos permite listar el equipo por id")
    @ApiResponse(responseCode = "200", description = "Se lista el equipo")
    @GetMapping("/get/{teamId}")
    public Mono<ResponseEntity<Mono<TeamDTO>>> getTeamById(@PathVariable("teamId") String teamId){
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.getTeam(teamId))
            );

        } catch (Exception e){
            throw new RuntimeException("No se pudo obtener el curso");
        }
    }

    /**
     * Endoip para eliminar un team for id
     *
     * @param teamId
     * @return Mono<ResponseEntity<Mono<Void></>></Moono>
     */
    @Operation(summary = "---> Endpoint que nos permite eliminar un equipo por id")
    @ApiResponse(responseCode = "200", description = "Se elimino el equipo")
    @DeleteMapping("/delete/{teamId}")
    public Mono<ResponseEntity<Mono<Void>>> deleteTeam(@PathVariable("teamId") String teamId){
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.deleteTeam(teamId))
            );

        } catch (Exception e){
            throw new RuntimeException("No se puede elimar el equipo con exito");
        }
    }


    /**
     * Endpoint para actualizar un equipo
     *
     * @param teamDTO
     * @param teamId
     * @return Mono<ResponseEntity<Mono<TeamDTO></></Mono>></Mono>></>
     */
    @Operation(summary = "---> Endpoint que nos permite Actualizar un equipo por id")
    @ApiResponse(responseCode = "200", description = "Se Actualizo el equipo")
    @PutMapping("/update/{teamId}")
    public Mono<ResponseEntity<Mono<TeamDTO>>> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable("teamId") String teamId){
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.updateTeam(teamId,teamDTO))
            );
        } catch (Exception e){
            throw new RuntimeException("No se pudo actualizar el equipo");
        }
    }

//    @Operation(summary = "---> Endpoint que nos permite listar el equipo")
//    @ApiResponse(responseCode = "200", description = "Se lista el equipo")
//    @GetMapping (value ="api/listteam")
//    public ResponseEntity<List<TeamDTO>> listarTeam(){
//        List<TeamDTO> list = teamService.listarTeam();
//        return ResponseEntity.status(HttpStatus.OK).body(list);
//    }



//    @PutMapping("api/updateTeam/{id}")
//    public void updateTeam(@PathVariable String ID,@RequestBody TeamDTO teamDTO){
//        try {
//            teamService.updateTeam(teamDTO);
//        } catch (Exception e){
//            throw  new RuntimeException("No se puede actudalizar Equipo");
//        }
//    }

}
