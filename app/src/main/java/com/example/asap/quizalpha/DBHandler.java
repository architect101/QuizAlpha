package com.example.asap.quizalpha;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by sagar on 3/23/2016.
 */
public class DBHandler extends SQLiteAssetHelper{
    public static final int Database_Version = 1;
    private Context dbcontext;
    SQLiteDatabase db;
  public static final String TAG="tagthis";
    public static final String Database_Name = "QuestionBank.sqlite";
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,Database_Name, null, Database_Version);
        dbcontext=context;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void getQuestions(String Table_name,int level,ArrayList<QuestionFormat> qstnlist)
    {
        level = level*5;
        QuestionFormat qstns;
        String query = "Select * From " + Table_name;
        db = getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        //Log.i(TAG, " Not Adding " + c.getString(c.getColumnIndex("Questions")));
        int i=0;
        while(i<LevelActivity.Max_Questions)
        {
            if(!c.isAfterLast())
            {
                qstns= new QuestionFormat();

                qstns.setQuestion(c.getString(c.getColumnIndex("Questions")));
                qstns.setOption1(c.getString(c.getColumnIndex("Opt1")));
                qstns.setOption2(c.getString(c.getColumnIndex("Opt2")));
                qstns.setOption3(c.getString(c.getColumnIndex("Opt3")));
                qstns.setOption4(c.getString(c.getColumnIndex("Opt4")));
                qstns.setAns(c.getString(c.getColumnIndex("Ans")));
                qstnlist.add(qstns);
                c.moveToNext();
            }
            else
            {
                Toast.makeText(dbcontext,"Question Database Corrupted , reinstall Application",Toast.LENGTH_LONG).show();

                break;
            }

            i++;
        }
        db.close();
    }
}
