package ru.mirea.kachalov.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class stories extends Fragment {
    private RecyclerView stories;
    private ItemStory itemStory;
    List<Story> listStories;

    public stories() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);
        AppDatabase db = App.getInstance().getDatabase();
        StoryDao storyDao = db.storyDao();
        stories = view.findViewById(R.id.stories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        stories.setLayoutManager(layoutManager);
        stories.setHasFixedSize(true);
        listStories = storyDao.getAll();
        itemStory = new ItemStory(listStories);
        stories.setAdapter(itemStory);
        return view;
    }
}