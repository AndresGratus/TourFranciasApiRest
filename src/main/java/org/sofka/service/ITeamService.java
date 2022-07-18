package org.sofka.service;

import org.sofka.dto.TeamDTO;
import reactor.core.publisher.Mono;

public interface ITeamService {

    /**
     * Crear Team
     *
     * @param  teamDTO
     * @return Mono<TeamDTO></TeamDTO>
     */
    Mono<TeamDTO> createTeam(TeamDTO teamDTO);

    /**
     * Mostrar Team for id
     *
     * @param  teamId
     * @return Mono<TeamDTO></TeamDTO>
     */
    Mono<TeamDTO> getTeam(String teamId);

    /**
     * Eliminar un Team for id
     *
     * @param teamId
     * @return Mono<TeamDTO></TeamDTO>
     */

    Mono<Void> deleteTeam(String teamId);

    /**
     * Actualizar Team
     *
     * @param teamId
     * @return Mono<TeamDTO></TeamDTO>
     */
    Mono<TeamDTO> updateTeam(String teamId, TeamDTO teamDTO);


}
