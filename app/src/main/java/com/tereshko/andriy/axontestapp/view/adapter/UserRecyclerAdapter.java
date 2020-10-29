package com.tereshko.andriy.axontestapp.view.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.tereshko.andriy.axontestapp.R;
import com.tereshko.andriy.axontestapp.model.Result;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 28/10/20
 */
public class UserRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<Result> itemList;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public UserRecyclerAdapter(List<Result> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == VIEW_TYPE_ITEM){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
            return new UserViewHolder(view);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_bar_list_item, parent, false);
            return new LoadingViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof UserViewHolder)
            ((UserViewHolder) holder).bind(itemList.get(position));
    }


    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.user_list_full_name)
        TextView fullNameTextView;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.user_list_age)
        TextView ageTextView;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.user_list_phone)
        TextView phoneTextView;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.user_list_item_picture)
        ImageView picture;
        View itemView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void bind(Result result){
            String yearsOld = "";
            if(result.getDob().getAge().equals("1"))
                yearsOld = itemView.getContext().getString(R.string.year_old);
            else if(result.getDob().getAge().equals("0"))
                ageTextView.setVisibility(View.INVISIBLE);
            else
                yearsOld = itemView.getContext().getString(R.string.years_old);
            fullNameTextView.setText(String.format("%s %s", result.getName().getFirstName(), result.getName().getSurname()));
            ageTextView.setText(String.format("%s %s", result.getDob().getAge(), yearsOld));
            phoneTextView.setText(String.format("%s", result.getPhone()));
            Picasso.get().load(result.getUserPicture().getPictureURL()).into(picture);
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.user_list_progress_bar)
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
