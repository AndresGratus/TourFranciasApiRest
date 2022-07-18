package org.sofka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class TeamDTO {

    private String teamId;

    private String name;

    private String codeTeam;

    private ArrayList<CyclistDTO> listCyclist;

}
