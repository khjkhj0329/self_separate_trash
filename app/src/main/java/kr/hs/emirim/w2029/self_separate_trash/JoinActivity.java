package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    JoinActivity.MyDBHelper dbHelper;
    SQLiteDatabase db;
    EditText joinId, joinPwd;
    Button joinBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        setTitle("회원가입 DB");

        joinId = findViewById(R.id.input_id);
        joinPwd = findViewById(R.id.input_pwd);
        joinBtn = findViewById(R.id.join_btn);
        
        dbHelper = new JoinActivity.MyDBHelper(this);
        
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO joinTB VALUES (" +
                        "'"+ joinId.getText().toString() + "','"
                        + joinPwd.getText().toString() + "');");
                db.close();
//                Toast.makeText(getApplicationContext(), "행이 삽입되었습니다.", Toast.LENGTH_SHORT).show();
                selectDB();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void selectDB() {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from joinTB;", null);
        String Id = "아이디\r\n_____________\r\n";
        String Pwd = "비밀번호\r\n_____________\r\n";
        while (cursor.moveToNext()){
            Id+=cursor.getInt(1) + "\r\n";
            Pwd+=cursor.getInt(2) + "\r\n";
        }
        cursor.close();
        db.close();
    }
    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context){
            super(context,"joinTB",null, 3);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table joinTB(id char(20) primary key, pwd char(20));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists joinTB");
            onCreate(db);
        }
    }
}
