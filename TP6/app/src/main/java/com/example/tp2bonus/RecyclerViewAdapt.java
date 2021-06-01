package com.example.tp2bonus;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapt extends RecyclerView.Adapter<RecyclerViewAdapt.DataContainer> {
    private Context context;
    private final List<Planete> data;

    public RecyclerViewAdapt(Context context, List<Planete> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public DataContainer onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recyclerview_item, parent, false);
        return new DataContainer(view);
    }

    @Override
    public void onBindViewHolder(DataContainer container, int position) {
        container.name.post(() -> {
            String name = context.getString(R.string.nom) + " : " + data.get(position).getNom();
            container.name.setText(name);
        });
        container.Taille.post(() -> {
            String size = context.getString(R.string.Taille) + " : " + data.get(position).getTaille() + "km";
            container.Taille.setText(size);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DataContainer extends RecyclerView.ViewHolder {
        TextView name;
        TextView Taille;

        public DataContainer(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nom);
            Taille = (TextView) itemView.findViewById(R.id.Taille);
        }
    }
}