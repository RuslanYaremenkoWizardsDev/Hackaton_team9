package com.github.repository;

import com.github.entity.Tournament;

import java.sql.Date;
import java.util.Collection;

public interface ITournamentRepository {

    Collection<Tournament> findAll();

    Tournament findById(Long tournament_id);

    Tournament findByTourName(String tourName);

    Tournament findByPlayers(String players);

    Tournament findByDate(Date date);

    Tournament findByScenario(String scenario);

    void  update(Tournament tournament);

    void insert(Tournament tournament);

    void tournamentCreator();
}
