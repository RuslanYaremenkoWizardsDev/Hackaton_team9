package com.github.repository;

import com.github.entity.Tournament;

import java.sql.Date;
import java.util.Collection;

public class TournamentRepository implements ITournamentRepository {

    @Override
    public Collection<Tournament> findAll() {
        return null;
    }

    @Override
    public Tournament findById(Long tournament_id) {
        return null;
    }

    @Override
    public Tournament findByTourName(String tourName) {
        return null;
    }

    @Override
    public Tournament findByPlayers(String players) {
        return null;
    }

    @Override
    public Tournament findByDate(Date date) {
        return null;
    }

    @Override
    public Tournament findByScenario(String scenario) {
        return null;
    }

    @Override
    public void update(Tournament tournament) {

    }

    @Override
    public void insert(Tournament tournament) {

    }

    @Override
    public void tournamentCreator() {

    }
}
