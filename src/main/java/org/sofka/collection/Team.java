package org.sofka.collection;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document (collection = "team")
public class Team {
    @Id
    private String teamId;

    private String name;

    private String codeTeam;

    private ArrayList<Cyclist> listCyclist;
}
