package org.sofka.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "cyclist")
public class Cyclist {
    @Id
    private String cyclistId;

    private String nameCyclist;

    private String numberID;

    private String country;

    private String region;
}
