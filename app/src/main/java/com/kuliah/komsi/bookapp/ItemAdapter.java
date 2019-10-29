package com.kuliah.komsi.bookapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ItemData> values;
    private LayoutInflater inflater;
    public ItemAdapter(Context context, ArrayList<ItemData> values){
        this.context = context;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ItemData data = values.get(position);
        viewHolder.titleText.setText(data.itemTitle);
        viewHolder.subText.setText(data.itemSubtitle);

        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        Toast.makeText(context, "Anda pilih " + data.itemTitle, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        viewHolder.itemView.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        values.remove(data);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Anda menghapus " + data.itemTitle, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView subText;
        public ViewHolder(View view){
            super(view);
            titleText = view.findViewById(R.id.text1);
            subText = view.findViewById(R.id.text2);
        }
    }

}
