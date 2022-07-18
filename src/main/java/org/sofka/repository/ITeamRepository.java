package org.sofka.repository;

import org.sofka.collection.Team;
import org.sofka.dto.TeamDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends ReactiveMongoRepository<Team, String> {
}
