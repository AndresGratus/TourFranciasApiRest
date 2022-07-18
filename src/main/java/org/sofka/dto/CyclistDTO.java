package org.sofka.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CyclistDTO {


    private String cyclistId;

    private String nameCyclist;

    private String numberId;

    private String country;

    private String region;
}
