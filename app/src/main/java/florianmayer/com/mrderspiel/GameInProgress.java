package florianmayer.com.mrderspiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class GameInProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_in_progress);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.playerAliveList);
        KillPlayerAdapter adapter = new KillPlayerAdapter(Gamemaster.getGamemaster().getPlayers());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
