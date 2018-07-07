package florianmayer.com.mrderspiel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerTextView;
        public Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            playerTextView = (TextView) itemView.findViewById(R.id.player_name);
            deleteButton=(Button) itemView.findViewById(R.id.delete_player_button);
        }
    }

    private List<Player> mPlayers;

    public PlayerAdapter(List<Player> players) {
        mPlayers = players;
    }

    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View playerView = inflater.inflate(R.layout.item_player, parent, false);
        ViewHolder viewHolder = new ViewHolder(playerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlayerAdapter.ViewHolder viewHolder, final int position) {
        Player player = mPlayers.get(position);
        TextView textView = viewHolder.playerTextView;
        textView.setText(player.getName());
        Button button = viewHolder.deleteButton;
        button.setText("Löschen");
        button.setEnabled(true);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Gamemaster.getGamemaster().removePlayerAtIndex(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mPlayers.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
}
