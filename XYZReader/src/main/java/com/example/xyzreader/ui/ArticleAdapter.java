package com.example.xyzreader.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<String> mArticleList;

    public ArticleAdapter(List<String> articleList) {
        mArticleList = articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.article_text;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@SuppressWarnings("NullableProblems") ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mArticleList == null ? 0 : mArticleList.size();
    }

    public void setArticleData(List<String> articleList) {
        mArticleList = articleList;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView articleLongTextView;

        ViewHolder(View itemView) {
            super(itemView);
            articleLongTextView = itemView.findViewById(R.id.longtext_view);
        }

        void bind(int listIndex) {
            String text = mArticleList.get(listIndex);
            articleLongTextView.setText(text);
        }
    }
}
