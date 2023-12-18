package com.example.minikindle;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.minikindle.Adapter.MyChapterAdapter;
import com.example.minikindle.Common.Common;
import com.example.minikindle.Model.Comic;

public class ChaptersActivity extends AppCompatActivity {

    RecyclerView recycler_chapter;
    TextView txt_chapter_name;
    LinearLayoutManager layoutManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        //View
        txt_chapter_name = (TextView)findViewById(R.id.txt_chapter_name);
        recycler_chapter = (RecyclerView)findViewById(R.id.recycler_chapter);
        recycler_chapter.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_chapter.setLayoutManager(layoutManager);
        recycler_chapter.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));



        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(Common.comicSelected.Name);

        //SetIcon
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fetchChapter(Common.comicSelected);
    }

    private void fetchChapter(Comic comicSelected) {
        Common.chapterList = comicSelected.Chapters;
        recycler_chapter.setAdapter(new MyChapterAdapter(this,comicSelected.Chapters));
        txt_chapter_name.setText(new StringBuilder("CHAPTER (").append(comicSelected.Chapters.size()).append(")"));
    }
}
