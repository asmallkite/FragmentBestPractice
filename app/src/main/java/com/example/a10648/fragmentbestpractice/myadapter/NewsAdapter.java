package com.example.a10648.fragmentbestpractice.myadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a10648.fragmentbestpractice.R;
import com.example.a10648.fragmentbestpractice.model.News;

import java.util.List;

/**
 * Created by 李争 on 2016/6/16 0016.
 */
public class NewsAdapter extends ArrayAdapter<News>{
    private int resourceId;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else {
            view = convertView;
        }
        TextView newsTitleId = (TextView)view.findViewById(R.id.news_title_id);
        newsTitleId.setText(String.valueOf(news.getTitleId()));
        TextView newsTitleText = (TextView)view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());

        Log.d("NewsAdapter","this");
        return view;
    }
}
