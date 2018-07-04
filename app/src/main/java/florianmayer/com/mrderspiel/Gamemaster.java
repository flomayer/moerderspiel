package florianmayer.com.mrderspiel;

import android.app.Activity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Gamemaster {
    public List<Player> shuffle(List<Player> playerlist) {
        Collections.shuffle(playerlist);
        for (Player p : playerlist
                ) {
            if (playerlist.indexOf(p) == playerlist.size() - 1) {
                p.setTarget(playerlist.get(1));
            } else {
                p.setTarget(playerlist.get(playerlist.indexOf(p) + 1));
            }
        }
        Collections.shuffle(playerlist);
        return playerlist;
    }


}


