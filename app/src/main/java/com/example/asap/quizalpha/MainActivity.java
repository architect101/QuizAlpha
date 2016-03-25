package com.example.asap.quizalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    int level =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Analytical(View v)
    {
        Intent i = new Intent(this,LevelActivity.class);
        i.putExtra("category","Analytical");
        i.putExtra("level",level);
        startActivity(i);

    }
    public void Mathematical(View v)
    {
        Intent i = new Intent(this,LevelActivity.class);
        i.putExtra("category","Mathematical");
        i.putExtra("level",level);
        startActivity(i);
    }
    public void Physics(View v)
    {
        Intent i = new Intent(this,LevelActivity.class);
        i.putExtra("category","Mathematical");
        i.putExtra("level",level);
        startActivity(i);
    }
    public void Biology(View v)
    {
        Intent i = new Intent(this,LevelActivity.class);
        i.putExtra("category","Mathematical");
        i.putExtra("level",level);
        startActivity(i);
    }
}
