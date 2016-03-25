package com.example.asap.quizalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Score_Activity extends AppCompatActivity {
    String Category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_);
        Bundle data = getIntent().getExtras();
        int score = data.getInt("result");
        Category = data.getString("category");
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);
        bar.setNumStars(score);
        bar.setIsIndicator(true);
        if(score<4)
        {
            Button b= (Button) findViewById(R.id.next_level);
            Button s =(Button) findViewById(R.id.share_button);
            b.setText("RETRY");
            s.setVisibility(View.GONE);
        }
    }
    public void NextLevel(View v)
    {
        Button b= (Button) findViewById(R.id.next_level);
        if(b.getText()=="RETRY")
        {
            Intent i = new Intent(this,LevelActivity.class);
            i.putExtra("category",Category);
            i.putExtra("Category",LevelActivity.level);
            startActivity(i);
        }
        else
        {
            int level = LevelActivity.level + 1;
            Intent i = new Intent(this,LevelActivity.class);
            i.putExtra("category",Category);
            i.putExtra("level",level);
            startActivity(i);
        }
    }
    public void ShareScore(View v)
    {

    }
}
