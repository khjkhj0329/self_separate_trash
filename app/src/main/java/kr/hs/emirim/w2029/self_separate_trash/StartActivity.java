package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    ImageButton recyclingBtn, menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        recyclingBtn = findViewById(R.id.recycling_btn);
        menuBtn = findViewById(R.id.menu_btn);
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
                Intent intent2 = new Intent(getApplicationContext(), RecyclingActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
