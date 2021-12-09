package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    MyDBHelper dbHelper;
    SQLiteDatabase db;
    Button insertBtn;
    ImageButton homeBtn, backBtn;
    EditText insertName, insertInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_in);

        homeBtn = findViewById(R.id.home_btn);
        backBtn = findViewById(R.id.back_btn);

        insertName = findViewById(R.id.name);
        insertInfo = findViewById(R.id.info);
        insertBtn = findViewById(R.id.insert_btn);

        dbHelper = new MyDBHelper(this);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO insertTB VALUES (" +
                        "'"+ insertName.getText().toString() + "','"
                        + insertInfo.getText().toString() + "');");
                db.close();
                Toast.makeText(getApplicationContext(), "행이 삽입되었습니다.", Toast.LENGTH_SHORT).show();
                selectDB();
            }
        });
        insertBtn = findViewById(R.id.insert_btn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void selectDB() {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from insertTB;", null);
        String Name = "쓰레기 이름\r\n________________\r\n";
        String Info = "쓰레기 정보\r\n________________\r\n";
        while (cursor.moveToNext()){
            Name+=cursor.getString(0) + "\r\n";
            Info+=cursor.getString(0) + "\r\n";
        }
        cursor.close();
        db.close();
    }

    public class MyDBHelper extends SQLiteOpenHelper{
        public MyDBHelper(Context context) { super(context, "insertTB", null, 3 ); }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table insertTB(Name char(10) primary key, Info char(20));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists insertTB");
            onCreate(db);
        }
    }
}
