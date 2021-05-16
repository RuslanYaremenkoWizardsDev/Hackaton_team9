package com.github.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_id")
    private Long tournament_id;

    @Column(name = "tourName")
    private String tourName;

    @Column(name = "description")
    private String description;

    @Column(name = "mode")
    private String mode;

    @Column(name = "place")
    private String place;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "lastRegistration")
    private Date lastRegistration;

    @Column(name = "tourLvl")
    private String tourLvl;


    @Column(name = "playerQuantity")
    private int playerQuantity;

    @Column(name = "scenario")
    private String scenario;

    @Column(name = "players")
    private String players;

    public Tournament(Long tournament_id, String tourName, String description,
                      String mode, String place, Date startDate, Date lastRegistration,
                      String tourLvl, int playerQuantity, String scenario, String players) {
        this.tournament_id = tournament_id;
        this.tourName = tourName;
        this.description = description;
        this.mode = mode;
        this.place = place;
        this.startDate = startDate;
        this.lastRegistration = lastRegistration;
        this.tourLvl = tourLvl;
        this.playerQuantity = playerQuantity;
        this.scenario = scenario;
        this.players = players;
    }

    public Tournament() {

    }

    public Long getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(Long tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastRegistration() {
        return lastRegistration;
    }

    public void setLastRegistration(Date lastRegistration) {
        this.lastRegistration = lastRegistration;
    }

    public String getTourLvl() {
        return tourLvl;
    }

    public void setTourLvl(String tourLvl) {
        this.tourLvl = tourLvl;
    }

    public int getPlayerQuantity() {
        return playerQuantity;
    }

    public void setPlayerQuantity(int playerQuantity) {
        this.playerQuantity = playerQuantity;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return Objects.equals(tourName, tournament.tourName) &&
                Objects.equals(description, tournament.description) &&
                Objects.equals(mode, tournament.mode) &&
                Objects.equals(place, tournament.place) &&
                Objects.equals(startDate, tournament.startDate) &&
                Objects.equals(lastRegistration, tournament.lastRegistration) &&
                Objects.equals(tourLvl, tournament.tourLvl) &&
                Objects.equals(playerQuantity, tournament.playerQuantity) &&
                Objects.equals(scenario, tournament.scenario) &&
                Objects.equals(players, tournament.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourName, description,
                mode, place, startDate, lastRegistration, tourLvl,
                playerQuantity, scenario, players);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournament_id=" + tournament_id +
                "tourName=" + tourName +
                ", description='" + description + '\'' +
                ", mode='" + mode + '\'' +
                ", place='" + place + '\'' +
                ", startDate='" + startDate + '\'' +
                ", lastRegistration=" + lastRegistration + '\'' +
                ", tourLvl='" + tourLvl + '\'' +
                ", playerQuantity='" + playerQuantity + '\'' +
                ", scenario_for_tournament='" + scenario + '\'' +
                ", invited_players='" + players + '\'' +
                '}';
    }

}
