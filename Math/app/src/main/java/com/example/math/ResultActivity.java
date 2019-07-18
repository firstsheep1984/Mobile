package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.math.Model.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    TextView textView_score;
    EditText editText_name;
    Button button_back;
    String score;
    RadioGroup radioGroup;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();

        initializeListView();
        myGetIntent();
    }

    private void initialize() {
        textView_score = findViewById(R.id.textView_score);
        button_back = findViewById(R.id.button_back);
        editText_name = findViewById(R.id.editText_name);
        radioGroup = findViewById(R.id.radioGroup);
    }


    private void initializeListView() {
        listView = findViewById(R.id.listView);
        listView_displayAll();
    }

    private void listView_displayAll() {
        ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.questionAndAnswerList);
        listView.setAdapter(listAdapter);
    }

    private void myGetIntent() {
        Intent intent = getIntent();
        score = intent.getStringExtra("score");
        textView_score.setText(score);
    }

    public void clickBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("return_result", editText_name.getText().toString() + " " + score);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }

    public void clickRadioButton(View view) {
        int selectRadioBtn = radioGroup.getCheckedRadioButtonId();
        switch (selectRadioBtn) {
            case R.id.radioButton_all:
                listView_displayAll();
                break;
            case R.id.radioButton_right:
                listView_displayRight();
                break;
            case R.id.radioButton_wrong:
                listView_displayWrong();
                break;
            case R.id.radioButton_sortA:
                sortA();
                break;
            case R.id.radioButton_sortD:
                sortD();
                break;
        }
    }

    private void sortD() {
        Collections.sort(MainActivity.questionAndAnswerList, new Comparator<QuestionAndAnswer>() {
            @Override
            public int compare(QuestionAndAnswer o1, QuestionAndAnswer o2) {
                return o2.getAnswer() - o1.getAnswer();
            }
        });
        ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.questionAndAnswerList);
        listView.setAdapter(listAdapter);
    }

    private void sortA() {
      /*  Collections.sort(MainActivity.questionAndAnswerList, new Comparator<QuestionAndAnswer>() {
            @Override
            public int compare(QuestionAndAnswer o1, QuestionAndAnswer o2) {
                return o1.getAnswer() - o2.getAnswer();
            }
        });
        */
        Collections.sort(MainActivity.questionAndAnswerList, (QuestionAndAnswer e1, QuestionAndAnswer e2) -> {
            return e1.getAnswer() - e2.getAnswer();
        });
        ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.questionAndAnswerList);
        listView.setAdapter(listAdapter);
    }

    private void listView_displayWrong() {
        List<QuestionAndAnswer> secondQustionAndAnswerList = new ArrayList<>();
        Iterator<QuestionAndAnswer> itr = MainActivity.questionAndAnswerList.iterator();
        while (itr.hasNext()) {
            QuestionAndAnswer q = itr.next();
            if (!q.isJudge()) {
                secondQustionAndAnswerList.add(q);
                ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, secondQustionAndAnswerList);
                listView.setAdapter(listAdapter);
            }
        }
    }

    private void listView_displayRight() {
        List<QuestionAndAnswer> secondQustionAndAnswerList = new ArrayList<>();
        // MainActivity.questionAndAnswerList.stream().filter(q -> q.);
        Iterator<QuestionAndAnswer> itr = MainActivity.questionAndAnswerList.iterator();
        while (itr.hasNext()) {
            QuestionAndAnswer q = itr.next();
            if (q.isJudge()) {
                secondQustionAndAnswerList.add(q);
                ArrayAdapter<QuestionAndAnswer> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, secondQustionAndAnswerList);
                listView.setAdapter(listAdapter);
            }
        }
    }

    public void showAll(View view) {
        listView_displayAll();
    }
}
