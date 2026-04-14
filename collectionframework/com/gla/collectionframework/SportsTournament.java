package com.gla.collectionframework;

import java.util.*;

public class SportsTournament {
    private Set<Team> teams;
    private Queue<Match> scheduledMatches;
    private List<Match> completedMatches;
    private TreeSet<Team> standings;

    public SportsTournament() {
        this.teams = new HashSet<>();
        this.scheduledMatches = new LinkedList<>();
        this.completedMatches = new ArrayList<>();
        this.standings = new TreeSet<>(Comparator.comparingInt(Team::getPoints).reversed());
    }

    public void registerTeam(Team team) {
        teams.add(team);
        standings.add(team);
    }

    public void scheduleMatch(Match match) {
        scheduledMatches.offer(match);
    }

    public void recordMatchResult(Match match, Team winner, int winnerScore, int loserScore) {
        if (scheduledMatches.contains(match)) {
            scheduledMatches.remove(match);
            match.setWinner(winner);
            match.setWinnerScore(winnerScore);
            match.setLoserScore(loserScore);
            completedMatches.add(match);
            winner.addPoints(3);
            standings.remove(winner);
            standings.add(winner);
        }
    }

    public Match getNextMatch() {
        return scheduledMatches.peek();
    }

    public List<Match> getMatchesByTeam(String teamId) {
        List<Match> teamMatches = new ArrayList<>();
        for (Match m : completedMatches) {
            if (m.getTeam1().getTeamId().equals(teamId) || m.getTeam2().getTeamId().equals(teamId)) {
                teamMatches.add(m);
            }
        }
        return teamMatches;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public TreeSet<Team> getStandings() {
        return standings;
    }

    public static void main(String[] args) {
        SportsTournament tournament = new SportsTournament();
        Team t1 = new Team("T001", "Eagles");
        Team t2 = new Team("T002", "Tigers");
        Team t3 = new Team("T003", "Lions");
        tournament.registerTeam(t1);
        tournament.registerTeam(t2);
        tournament.registerTeam(t3);
        Match m1 = new Match("M001", t1, t2);
        tournament.scheduleMatch(m1);
        System.out.println("Next match: " + tournament.getNextMatch());
        tournament.recordMatchResult(m1, t1, 3, 1);
        System.out.println("Standings: " + tournament.getStandings());
        System.out.println("T1 matches: " + tournament.getMatchesByTeam("T001"));
    }
}

class Team {
    private String teamId;
    private String name;
    private int points;

    public Team(String teamId, String name) {
        this.teamId = teamId;
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public String getTeamId() { return teamId; }
    public String getName() { return name; }
    public int getPoints() { return points; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId);
    }

    @Override
    public String toString() {
        return name + "(" + points + ")";
    }
}

class Match {
    private String matchId;
    private Team team1;
    private Team team2;
    private Team winner;
    private int winnerScore;
    private int loserScore;

    public Match(String matchId, Team team1, Team team2) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
    }

    public void setWinner(Team winner) { this.winner = winner; }
    public void setWinnerScore(int score) { this.winnerScore = score; }
    public void setLoserScore(int score) { this.loserScore = score; }

    public String getMatchId() { return matchId; }
    public Team getTeam1() { return team1; }
    public Team getTeam2() { return team2; }
    public Team getWinner() { return winner; }
    public int getWinnerScore() { return winnerScore; }
    public int getLoserScore() { return loserScore; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(matchId, match.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId);
    }

    @Override
    public String toString() {
        return team1.getName() + " vs " + team2.getName();
    }
}
