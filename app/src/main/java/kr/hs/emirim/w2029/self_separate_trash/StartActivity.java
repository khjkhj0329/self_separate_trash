package kr.hs.emirim.w2029.self_separate_trash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    ImageButton recyclingBtn, menuBtn, trashBtn, mypageBtn;
    TextView logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        recyclingBtn = findViewById(R.id.recycling_btn);
        menuBtn = findViewById(R.id.menu_btn);
//        searchBtn = findViewById(R.id.search_btn);
        trashBtn = findViewById(R.id.trash_btn);
        logoutBtn = findViewById(R.id.log_out);

        // 로그아웃
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setMessage("로그아웃 하시겠습니까?");
                builder.setTitle("로그아웃 알림창")
                        .setCancelable(false)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("로그아웃");
                alert.show();
            }
        });

//        searchBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EtcMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        recyclingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecyclingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        trashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrashActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
