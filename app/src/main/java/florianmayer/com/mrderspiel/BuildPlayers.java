package florianmayer.com.mrderspiel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BuildPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_players);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        Player dummy = new Player("dummy");
        Player dummy2 = new Player("dummy2");

        Gamemaster.getGamemaster().addPlayer(dummy);
        Gamemaster.getGamemaster().addPlayer(dummy2);*/
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.playerlist);
        CreatePlayerAdapter adapter = new CreatePlayerAdapter(Gamemaster.getGamemaster().getPlayers());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        ImageButton addPlayer = (ImageButton) findViewById(R.id.btnAddPlayer);
        addPlayer.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                Player p = new Player(txtPlayerName.getText().toString());
                Gamemaster.getGamemaster().addPlayer(p);
                txtPlayerName.setText(null);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        ImageButton btnGameStart = (ImageButton) findViewById(R.id.btnGameStart);
        btnGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gamemaster.getGamemaster().shuffle();
                startActivity(new Intent(BuildPlayers.this, GameInProgress.class));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
