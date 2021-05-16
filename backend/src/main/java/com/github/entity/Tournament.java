package com.github.entity;

import java.sql.Date;
import java.util.Objects;

public class Tournament {

    private int tournament_id;

    private String tournament_name;

    private String tournament_description;

    private String mode;

    private String place;

    private Date datestart;

    private Date datepicker;

    private String level_of_tournament;

    private int number_of_participants;

    private String scenario_for_tournament;

    private String invited_players;

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }


    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getTournament_description() {
        return tournament_description;
    }

    public void setTournament_description(String tournament_description) {
        this.tournament_description = tournament_description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatepicker() {
        return datepicker;
    }

    public void setDatepicker(Date datepicker) {
        this.datepicker = datepicker;
    }

    public String getLevel_of_tournament() {
        return level_of_tournament;
    }

    public void setLevel_of_tournament(String level_of_tournament) {
        this.level_of_tournament = level_of_tournament;
    }

    public int getNumber_of_participants() {
        return number_of_participants;
    }

    public void setNumber_of_participants(int number_of_participants) {
        this.number_of_participants = number_of_participants;
    }

    public String getScenario_for_tournament() {
        return scenario_for_tournament;
    }

    public void setScenario_for_tournament(String scenario_for_tournament) {
        this.scenario_for_tournament = scenario_for_tournament;
    }

    public String getInvited_players() {
        return invited_players;
    }

    public void setInvited_players(String invited_players) {
        this.invited_players = invited_players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return Objects.equals(tournament_name, tournament.tournament_name) &&
                Objects.equals(tournament_description, tournament.tournament_description) &&
                Objects.equals(mode, tournament.mode) &&
                Objects.equals(place, tournament.place) &&
                Objects.equals(datestart, tournament.datestart) &&
                Objects.equals(datepicker, tournament.datepicker) &&
                Objects.equals(level_of_tournament, tournament.level_of_tournament) &&
                Objects.equals(number_of_participants, tournament.number_of_participants) &&
                Objects.equals(scenario_for_tournament, tournament.scenario_for_tournament) &&
                Objects.equals(invited_players, tournament.invited_players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournament_name, tournament_description,
                mode, place, datestart, datepicker, level_of_tournament,
                number_of_participants, scenario_for_tournament, invited_players);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournament_name=" + tournament_name +
                ", tournament_description='" + tournament_description + '\'' +
                ", mode='" + mode + '\'' +
                ", place='" + place + '\'' +
                ", datestart='" + datestart + '\'' +
                ", datepicker=" + datepicker + '\'' +
                ", level_of_tournament='" + level_of_tournament + '\'' +
                ", number_of_participants='" + number_of_participants + '\'' +
                ", scenario_for_tournament='" + scenario_for_tournament + '\'' +
                ", invited_players='" + invited_players + '\'' +
                '}';
    }

}
