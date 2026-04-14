package com.gla.collectionframework;

import java.util.*;

public class GamingTournament {
    private Set<Player> players;
    private Queue<Match> upcomingMatches;
    private List<Match> completedMatches;
    private TreeSet<Player> leaderboard;

    public GamingTournament() {
        this.players = new HashSet<>();
        this.upcomingMatches = new LinkedList<>();
        this.completedMatches = new ArrayList<>();
        this.leaderboard = new TreeSet<>(Comparator.comparingInt(Player::getScore).reversed());
    }

    public void registerPlayer(Player player) {
        players.add(player);
        leaderboard.add(player);
    }

    public void scheduleMatch(Match match) {
        upcomingMatches.offer(match);
    }

    public void completeMatch(Match match, Player winner) {
        if (upcomingMatches.contains(match)) {
            upcomingMatches.remove(match);
            match.setWinner(winner);
            completedMatches.add(match);
            winner.addScore(100);
            leaderboard.remove(winner);
            leaderboard.add(winner);
        }
    }

    public Player getNextMatchPlayer() {
        Match match = upcomingMatches.peek();
        return match != null ? match.getPlayer1() : null;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public TreeSet<Player> getLeaderboard() {
        return leaderboard;
    }

    public List<Match> getCompletedMatches() {
        return completedMatches;
    }

    public static void main(String[] args) {
        GamingTournament tournament = new GamingTournament();
        Player p1 = new Player("PL001", "PlayerOne");
        Player p2 = new Player("PL002", "PlayerTwo");
        Player p3 = new Player("PL003", "PlayerThree");
        tournament.registerPlayer(p1);
        tournament.registerPlayer(p2);
        tournament.registerPlayer(p3);
        Match m1 = new Match("M001", p1, p2);
        tournament.scheduleMatch(m1);
        tournament.completeMatch(m1, p1);
        System.out.println("Completed matches: " + tournament.getCompletedMatches().size());
        System.out.println("Leaderboard: " + tournament.getLeaderboard());
    }
}

class Player {
    private String playerId;
    private String name;
    private int score;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
        this.score = 0;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public String getPlayerId() { return playerId; }
    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}

class Match {
    private String matchId;
    private Player player1;
    private Player player2;
    private Player winner;

    public Match(String matchId, Player player1, Player player2) {
        this.matchId = matchId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getMatchId() { return matchId; }
    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public Player getWinner() { return winner; }

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
}
