package florianmayer.com.mrderspiel;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Gamemaster {
    private static Gamemaster gamemaster;

    private Gamemaster() {
        this.players = new ArrayList<>();
    }

    public synchronized static Gamemaster getGamemaster() {
        if (gamemaster == null) {
            gamemaster = new Gamemaster();
        }
        return gamemaster;
    }


    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayerAtIndex(int index) {
        this.players.remove(index);
    }

    public void shuffle() {
        Collections.shuffle(players);
        for (Player p : players
                ) {
            if (players.indexOf(p) == players.size() - 1) {
                p.setTarget(players.get(0));
            } else {
                p.setTarget(players.get(players.indexOf(p) + 1));
            }
        }
        Collections.shuffle(players);
    }

    public String getTargetNameForPlayerIndex(int index) {
        return players.get(index).getTarget().getName();
    }

}


