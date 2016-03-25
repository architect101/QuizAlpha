package com.example.asap.quizalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
    DBHandler db;
    static int level=0;
    String Category;
    Bundle screendata;
    ListAdapter qstnlist;
    final static int Max_Questions = 5;
    static boolean[] answer=new boolean[5];
    ArrayList<QuestionFormat> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        screendata = getIntent().getExtras();
        if(screendata==null)
            return;
        Category = screendata.getString("category");
        level = screendata.getInt("level");
        //getActionBar().setTitle(Category);
         questions= new ArrayList<QuestionFormat>();
         db= new DBHandler(this,null,null,0);
       db.getQuestions(Category,level,questions);

         qstnlist= new CustomAdapter(this,questions);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(qstnlist);

    }
    public void SubmitButton(View v)
    {
        int score=0;
        for(int i=0;i<Max_Questions;i++)
            if(answer[i])
                score++;
        Intent i =new Intent(this,Score_Activity.class);
        i.putExtra("result",score);
        i.putExtra("category",Category);
    startActivity(i);
    }


}
