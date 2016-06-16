package com.example.a10648.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a10648.fragmentbestpractice.model.News;
import com.example.a10648.fragmentbestpractice.myadapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10648 on 2016/6/15 0015.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTitleListView = (ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else {
            isTwoPane =false;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter  = new NewsAdapter(activity, R.layout.news_item, newsList);//how this works?????
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        News news = newsList.get(position);
        if (isTwoPane){
            NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(), news.getContent());
        }else {
            actionStart(getActivity(),news.getTitleid(), news.getTitle(), news.getContent());
        }
    }


    private List<News> getNews(){
        List<News> newsList = new ArrayList<News>();
//        News news1 = new News();
//        news1.setTitle("This is first news title");
//        news1.setContent("This is the first news Content.");
//        newsList.add(news1);
//        News news2 = new News("this is the second title", "I could not know whether this method " +
//                "will work");
//        newsList.add(news2);
//        News news3 = new News("kite","I am a small kite");
//        newsList.add(news3);
        News news1 = new News();
        news1.setTitleid(1);
        news1.setTitle("This is first news title");
        news1.setContent("This is the first news Content.");
        newsList.add(news1);
        News news2 = new News(2,"this is the second title", "I could not know whether this method " +
                "will work");
        newsList.add(news2);
        News news3 = new News(3,"kite","I am a small kite");
        newsList.add(news3);
        News news4 =new  News(4, "title4","This is the content of 4");
        newsList.add(news4);
        return newsList;
    }
    public static void actionStart(Context context,int titelid, String newsTitle, String newsContent){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_titleId", titelid);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }

}
