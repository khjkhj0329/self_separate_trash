package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    int version = 3;
    EditText idLogin, pwdLogin;

    DatabaseOpenHelper helper;
    SQLiteDatabase database;
    String sql;
    Cursor cursor;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    TextView joinBtn;
    Button loginBtn;

    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idLogin = findViewById(R.id.login_id);
        pwdLogin = findViewById(R.id.login_pwd);
        loginBtn = findViewById(R.id.login_btn);
        joinBtn = findViewById(R.id.join_btn);
        checkBox = findViewById(R.id.check_box);

        setting = getSharedPreferences("setting", 0);
        editor=setting.edit();

        if(setting.getString("chk_auto", "false").equals("true")){
            idLogin.setText(setting.getString("ID",""));
            pwdLogin.setText(setting.getString("PW",""));
            checkBox.setChecked(true);
        }

        helper = new DatabaseOpenHelper(LoginActivity.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    String ID = idLogin.getText().toString();
                    String PW = pwdLogin.getText().toString();

                    editor.putString("ID", ID);
                    editor.putString("PW", PW);
                    editor.putString("chk_auto", String.valueOf(true));
                    editor.commit();
                }else{
                    editor.clear();
                    editor.commit();
                }
                String id = idLogin.getText().toString();
                String pw = pwdLogin.getText().toString();

                // 아이디오 비밀번호 edit가 공백이면 toast 호출
                if (id.length() == 0 || pw.length() == 0){
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 입력해주세요 :)", Toast.LENGTH_SHORT).show();
                    return;
                }

                sql = "SELECT id FROM joinTB WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if (cursor.getCount() != 1){
                    //아이디 틀림
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 \n일치하지 않습니다 😒😒", Toast.LENGTH_SHORT).show();
                    return;
                }
                sql = "SELECT pwd FROM joinTB WHERE pwd = '" + pw + "'";
                cursor = database.rawQuery(sql, null);

                cursor.moveToNext();
                if (!pw.equals((cursor.getString(0)))){
                    //비밀번호 틀림
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 \n일치하지 않습니다 😒😒", Toast.LENGTH_SHORT).show();
                }else {
                    //로그인 성공
                    sql = "SELECT id FROM joinTB WHERE id = '" + id + "'";
                    cursor = database.rawQuery(sql, null);
                    cursor.moveToNext();
                    Toast.makeText(LoginActivity.this, cursor.getString(0)+"사용자님 환영합니다🧘️🧘🏻️", Toast.LENGTH_SHORT).show();
                    // 화면 전환
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(intent);
                    finish();
                }
                cursor.close();
            }
        });
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}