package com.javabro.service;

import com.javabro.model.Player;
import com.javabro.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlayerService {

    static List<Player> players = new ArrayList<>();
    static AtomicLong atomicLong = new AtomicLong(0);

    static {
        for(long i=0;i<10;i++) {
            long nextVal = atomicLong.incrementAndGet();
            players.add(new Player(nextVal, "ABC"+nextVal, new Team(nextVal, "Team "+nextVal, "Team "+nextVal+" desc")));
        }
    }
    public List<Player> getAllPlayers(){
        return players;
    }

    public Optional<Player> getPlayerById(Long id) {
        return players.stream().filter(player -> player.getId() == id).findFirst();
    }

    public Player addPlayer(Player player) {
        long nextVal = atomicLong.incrementAndGet();
        player.setId(nextVal);
        players.add(player);
        return player;
    }

    public Player updatePlayer(Player player, Long id) {
        Optional<Player> optionalPlayer = players.stream().filter(player1 -> player1.getId() == id).findFirst();
        Player player2 = optionalPlayer.orElseThrow();
        players.remove(player2);
        players.add(player);
        player.setId(id);
        return player;
    }

    public void deletePlayer(Long id) {
        Optional<Player> optionalPlayer = players.stream().filter(player -> player.getId() == id).findFirst();
        Player player2 = optionalPlayer.orElseThrow();
        players.remove(player2);
    }
}
