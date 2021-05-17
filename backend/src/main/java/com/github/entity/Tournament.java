package com.github.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tournament2")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_id")
    private Long tournament_id;

    @Column(name = "tour_name")
    private String tourName;

    @Column(name = "description")
    private String description;

    @Column(name = "mode")
    private String mode;

    @Column(name = "place")
    private String place;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "last_registration")
    private Long lastRegistration;

    @Column(name = "tour_level")
    private String tourLvl;

    @Column(name = "player_quantity")
    private int playerQuantity;

    @Column(name = "scenario")
    private String scenario;

    @Column(name = "players")
    private String players;

    @Column(name = "status")
    private String status;



    public Tournament() {

    }

    public Tournament(Long tournament_id, String tourName, String description, String mode, String place, Long startDate, Long lastRegistration, String tourLvl, int playerQuantity, String scenario, String players, String status) {
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
        this.status = status;
    }

    public Tournament(String tourName, String description, String mode, String place, Long startDate, Long lastRegistration, String tourLvl, int playerQuantity, String scenario, String players, String status) {
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
        this.status = status;
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



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getLastRegistration() {
        return lastRegistration;
    }

    public void setLastRegistration(Long lastRegistration) {
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
                Objects.equals(players, tournament.players)&&
                Objects.equals(status, tournament.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourName, description,
                mode, place, startDate, lastRegistration, tourLvl,
                playerQuantity, scenario, players,status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", status='" + status + '\'' +
                '}';
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
