package florianmayer.com.mrderspiel;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddPlayer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        testPopulateList();
    }
public void testPopulateList(){
    List<Player> playerList=new ArrayList<>();
    Player p1=new Player();
    Player p2=new Player();
    Player p3=new Player();
    p1.setName("Japanochinesensushimann");
    p2.setName("langer Lörres");
    p3.setName("Dödel");
    p1.setAlive(true);
    p2.setAlive(true);
    p3.setAlive(true);
    playerList.add(p1);
    playerList.add(p2);
    playerList.add(p3);
    ArrayAdapter<Player> adapter=new ArrayAdapter<>(this,R.layout.activity_new_game, playerList);
    ListView list=(ListView) findViewById(R.id.playerListView);
    list.setAdapter(adapter);
}
}
