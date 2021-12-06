package kr.hs.emirim.w2029.self_separate_trash;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity{
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        list = new ArrayList<String>();
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search_in);

        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list));
    }
    private void settingList(){
        list.add("마늘 껍질");
        list.add("게 껍데기");
        list.add("계란 껍데기");
        list.add("견과류 껍데기");
        list.add("과일류 씨앗");
        list.add("깨진 유리");
        list.add("나무 젓가락");
        list.add("동물 뼈");
        list.add("사기 그릇류");
        list.add("손톱");
        list.add("티백");
        list.add("음식물 포장랩");
        list.add("오염된 비닐");
        list.add("수건");
        list.add("신문지");
        list.add("전단지");
        list.add("종이박스");
        list.add("우유팩");
        list.add("종이컵");
        list.add("부탄가스");
        list.add("살충제 용기");
        list.add("공구");
        list.add("철사");
        list.add("못");
        list.add("전선");
        list.add("페트병");
        list.add("과자봉지");
        list.add("과자봉지");
        list.add("과자봉지");

    }
}
