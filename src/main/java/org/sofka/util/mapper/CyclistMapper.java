package org.sofka.util.mapper;

import org.sofka.collection.Cyclist;
import org.sofka.dto.CyclistDTO;

import java.util.function.Function;

public class CyclistMapper {

    /**
     * Metodo que nos permite transformar la colección Cyclist a su equivalente en Dto
     *
     * @return CyclistDTO
     */

    public Function<Cyclist, CyclistDTO> fromCyclistToCyclistDTO(){
        return  cyclist -> {
            CyclistDTO cyclistDTO = new CyclistDTO();
            cyclistDTO.setCyclistId(cyclist.getCyclistId());
            cyclistDTO.setNumberId(cyclist.getNumberID());
            cyclistDTO.setNameCyclist(cyclist.getNameCyclist());
            cyclistDTO.setCountry(cyclist.getCountry());
            cyclistDTO.setRegion(cyclist.getRegion());
            return cyclistDTO;
        };
    }

    /**
     * Metodo que nos permite transformar el Dto Cyclist a su equivalente en la Colección
     *
     * @return Cyclist
     */

    public  Function<CyclistDTO, Cyclist> fromCyclistDTOToCyclist(){
        return cyclistDTO -> {
            Cyclist cyclist = new Cyclist();
            cyclist.setCyclistId(cyclistDTO.getCyclistId());
            cyclist.setNumberID(cyclistDTO.getNumberId());
            cyclist.setNameCyclist(cyclistDTO.getNameCyclist());
            cyclist.setCountry(cyclistDTO.getCountry());
            cyclist.setRegion(cyclistDTO.getRegion());
            return cyclist;
        };
    }
}
