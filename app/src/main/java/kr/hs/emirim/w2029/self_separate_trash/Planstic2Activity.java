package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Planstic2Activity extends AppCompatActivity {
    ImageButton menuBtn, homeBtn, backBtn;
    TextView plansticView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planstic2);

        menuBtn = findViewById(R.id.menu_btn);
        homeBtn = findViewById(R.id.home_btn);
        backBtn = findViewById(R.id.back_btn);
        plansticView = findViewById(R.id.text_planstic2);
        plansticView.setMovementMethod(new ScrollingMovementMethod());

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EtcMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
                Intent intent = new Intent(getApplicationContext(), RecyclingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
