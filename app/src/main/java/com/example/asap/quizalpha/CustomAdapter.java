package com.example.asap.quizalpha;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sagar on 3/22/2016.
 */
public class CustomAdapter extends ArrayAdapter {
    private TextView qstn;
    private RadioButton opt1;
    private RadioButton opt2;
    private  RadioButton opt3;
    private RadioButton opt4;
    Context mycontext;
    QuestionFormat question;
    int index=-1;
    ArrayList<Answered>  answers =new ArrayList<Answered>();
    public CustomAdapter(Context context,ArrayList Qstns) {
        super(context, R.layout.custom_list, Qstns);
        mycontext = context;
        for(int i=0;i<LevelActivity.Max_Questions;i++) {
            Answered temp = new Answered();
            temp.qstn=(QuestionFormat)Qstns.get(i);
            temp.id=-1;
            temp.checked=false;
            answers.add(temp);
        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;


            LayoutInflater levelinflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = levelinflater.inflate(R.layout.custom_list, parent, false);


            qstn=(TextView) view.findViewById(R.id.question);
            opt1=(RadioButton) view.findViewById(R.id.rbutton1);
            opt2=(RadioButton) view.findViewById(R.id.rbutton2);
            opt3=(RadioButton) view.findViewById(R.id.rbutton3);
            opt4=(RadioButton) view.findViewById(R.id.rbutton4);



        question=(QuestionFormat) getItem(position);
        for(int i=0;i<answers.size();i++)
            if(question==answers.get(i).qstn)
            {index=i;break;}
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.get(index).id=opt1.getId();
                opt2.setChecked(false);
                opt3.setChecked(false);
                opt4.setChecked(false);
                answers.get(index).checked=true;
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.get(index).id=opt2.getId();
                opt1.setChecked(false);
                opt3.setChecked(false);
                opt4.setChecked(false);
                answers.get(index).checked=true;
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.get(index).id=opt3.getId();
                opt1.setChecked(false);
                opt2.setChecked(false);
                opt4.setChecked(false);
                answers.get(index).checked=true;
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.get(index).id=opt4.getId();
                opt1.setChecked(false);
                opt2.setChecked(false);
                opt3.setChecked(false);
                answers.get(index).checked=true;
            }
        });

        if(answers.get(index).checked==false)
        {
            opt1.setChecked(false);
            opt2.setChecked(false);
            opt3.setChecked(false);
            opt4.setChecked(false);
        }
        else
        {
            if(answers.get(index).id==opt1.getId())
                opt1.setChecked(true);
            else if(answers.get(index).id==opt2.getId())
                opt2.setChecked(true);
            else if(answers.get(index).id==opt3.getId())
                opt3.setChecked(true);
            else if(answers.get(index).id==opt4.getId())
                opt4.setChecked(true);
        }
        qstn.setText(question.getQuestion());
        opt1.setText(question.getOption1());
        opt2.setText(question.getOption2());
        opt3.setText(question.getOption3());
        opt4.setText(question.getOption4());

        return view;

    }

    }


