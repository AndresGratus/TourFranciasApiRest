package org.sofka.service.implementation;

import org.sofka.collection.Team;
import org.sofka.dto.TeamDTO;
import org.sofka.repository.ITeamRepository;
import org.sofka.service.ITeamService;
import org.sofka.util.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TeamService implements ITeamService{

    @Autowired
    private ITeamRepository teamRepository;

    /**
     * Se inyecta el mmaper Team
     */
    private TeamMapper teamMapper;

    public TeamService(){
        this.teamMapper = new TeamMapper();
    }
//
//    /**
//     * Listar Team
//     */
//    public List<TeamDTO> listarTeam(){
//        return repository.findAll();
//    }

    /**
     * Crear Team
     *
     * @param teamDTO
     * @return Mono<teamDTO></teamDTO>
     */
    @Override
    public Mono<TeamDTO> createTeam(TeamDTO teamDTO) {
        return teamRepository
                .save(teamMapper
                        .fromTeamDTOToTeam()
                        .apply(teamDTO))
                .map(teamMapper
                        .fromTeamToTeamDTO());
    }

    /**
     * Servicio para obtener un curso
     * @param teamId
     * @return Mono<TeamDTO></TeamDTO>
     */
    @Override
    public Mono<TeamDTO> getTeam(String teamId) {
        return teamRepository
                .findById(teamId)
                .map(teamMapper
                        .fromTeamToTeamDTO());
    }

    /**
     * Servicio par eliminar un team
     * @param teamId
     * @return
     */
    @Override
    public Mono<Void> deleteTeam(String teamId) {
        return teamRepository
                .deleteById(teamId);
    }

    @Override
    public Mono<TeamDTO> updateTeam(String teamId, TeamDTO teamDTO) {
        Mono<TeamDTO> teamDTOMono = teamRepository.findById(teamId)
                .map(team -> {
                    team.setName(teamDTO.getName());
                    team.setCodeTeam(teamDTO.getCodeTeam());
                    teamRepository.save(team);
                    return team;
                }).map(teamMapper.fromTeamToTeamDTO());
        return teamDTOMono;
    }

//    public TeamDTO updateTeam(TeamDTO teamDTO){
//        return  repository.save(teamDTO);
//    }

}
