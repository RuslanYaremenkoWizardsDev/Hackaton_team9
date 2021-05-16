package com.github.dto;


import java.sql.Date;
import java.util.Objects;

public class TournamentCreationDto {

    private String tourName;

    private String description;

    private boolean mode;

    private String place;

    private Long startDate;

    private Long lastRegistration;

    private String tourLvl;

    private int playerQuantity;

    private String scenario;

    private String players;

    private String status;

    public TournamentCreationDto() {
    }

    public TournamentCreationDto(String tourName, String description, boolean mode, String place, Date startDate, Date lastRegistration, String tourLvl, int playerQuantity, String scenario, String players) {
        this.tourName = tourName;
        this.description = description;
        this.mode = mode;
        this.place = place;
        this.startDate = startDate.getTime();
        this.lastRegistration = lastRegistration.getTime();
        this.tourLvl = tourLvl;
        this.playerQuantity = playerQuantity;
        this.scenario = scenario;
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentCreationDto that = (TournamentCreationDto) o;
        return mode == that.mode &&
                playerQuantity == that.playerQuantity &&
                Objects.equals(tourName, that.tourName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(place, that.place) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(lastRegistration, that.lastRegistration) &&
                Objects.equals(tourLvl, that.tourLvl) &&
                Objects.equals(scenario, that.scenario) &&
                Objects.equals(players, that.players) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourName, description, mode, place, startDate, lastRegistration, tourLvl, playerQuantity, scenario, players, status);
    }

    @Override
    public String toString() {
        return "TournamentCreationDto{" +
                "tourName='" + tourName + '\'' +
                ", description='" + description + '\'' +
                ", mode=" + mode +
                ", place='" + place + '\'' +
                ", startDate=" + startDate +
                ", lastRegistration=" + lastRegistration +
                ", tourLvl='" + tourLvl + '\'' +
                ", playerQuantity=" + playerQuantity +
                ", scenario='" + scenario + '\'' +
                ", players='" + players + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
