package florianmayer.com.mrderspiel;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class KillPlayerAdapter extends RecyclerView.Adapter<KillPlayerAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerTextView;
        public Button detailButton;

        public ViewHolder(View itemView) {
            super(itemView);
            playerTextView = (TextView) itemView.findViewById(R.id.player_name);
            detailButton = (Button) itemView.findViewById(R.id.player_detail_button);
        }
    }

    private List<Player> mPlayers;

    public KillPlayerAdapter(List<Player> players) {
        mPlayers = players;
    }

    @Override
    public KillPlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View playerView = inflater.inflate(R.layout.item_player_in_game, parent, false);
        ViewHolder viewHolder = new ViewHolder(playerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KillPlayerAdapter.ViewHolder viewHolder, final int position) {
        Player player = mPlayers.get(position);
        TextView textView = viewHolder.playerTextView;
        textView.setText(player.getName());
        Button button = viewHolder.detailButton;
        button.setText("Details");
        button.setEnabled(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, Gamemaster.getGamemaster().getTargetNameForPlayerIndex(position), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
}
