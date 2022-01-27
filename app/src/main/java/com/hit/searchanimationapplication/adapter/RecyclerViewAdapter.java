package com.hit.searchanimationapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
 import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.searchanimationapplication.ItemAnimation;
import com.hit.searchanimationapplication.R;
import com.hit.searchanimationapplication.UserDetials;
import com.hit.searchanimationapplication.model.UserData;

import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {
    Context context;
    static List<UserData> userDataList;
    static List<UserData> filteredUserDataList;

    public RecyclerViewAdapter(Context context, List<UserData> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
        this.filteredUserDataList = userDataList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row_item, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.userImage.setImageResource(filteredUserDataList.get(position).getImage());
        holder.userName.setText(filteredUserDataList.get(position).getUsern());
        holder.userDesc.setText(filteredUserDataList.get(position).getDescription());


        ItemAnimation.animateFadeIn(holder.itemView,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "Item clicked " + filteredUserDataList.get(position).getUsern(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, UserDetials.class);
                intent.putExtra("Username",filteredUserDataList.get(position).getUsern());
                context.startActivity(intent);
            }
        });

        holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item clicked " + filteredUserDataList.get(position).getUsern(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredUserDataList.size();
    }

    public final class RecyclerViewViewHolder extends RecyclerView.ViewHolder{
        CircleImageView userImage;
        TextView userName, userDesc;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.img_user);
            userName = itemView.findViewById(R.id.tv_userName);
            userDesc = itemView.findViewById(R.id.tv_userDesc);
        }


    }

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String key = charSequence.toString();

                if (key.isEmpty()){
                    filteredUserDataList = userDataList;
                }else {
                    List<UserData> filteredList = new ArrayList<>();

                    for (UserData row : userDataList){
                        if (row.getUsern().toLowerCase().contains(key.toLowerCase())){
                            filteredList.add(row);
                        }
                        filteredUserDataList = filteredList;
                    }

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredUserDataList = (List<UserData>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
