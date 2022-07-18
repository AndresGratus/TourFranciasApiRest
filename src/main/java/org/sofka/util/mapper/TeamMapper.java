package org.sofka.util.mapper;

import org.sofka.collection.Team;
import org.sofka.dto.TeamDTO;

import java.util.function.Function;

public class TeamMapper {
    /**
     * Metodo que nos permite transformar la colección team a su equivalente en Dto
     *
     * @return TeamDTO
     */

    public Function<Team, TeamDTO> fromTeamToTeamDTO(){
        return team -> {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setTeamId(team.getTeamId());
            teamDTO.setName(team.getName());
            teamDTO.setCodeTeam(team.getCodeTeam());
            return teamDTO;
        };
    }

    /**
     * Metodo que nos permite transformar el Dto team a su equivalente en la Colección
     *
     * @return Team
     */

    public Function<TeamDTO, Team> fromTeamDTOToTeam(){
        return teamDTO -> {
            Team team = new Team();
            team.setTeamId(teamDTO.getTeamId());
            team.setName(teamDTO.getName());
            team.setCodeTeam(teamDTO.getCodeTeam());
            return team;
        };
    }
}
