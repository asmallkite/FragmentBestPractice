package com.example.a10648.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 10648 on 2016/6/14 0014.
 */

public class NewsAdapter extends ArrayAdapter<News> {
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
        TextView newsTitleText = (TextView)view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
