package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RecyclingActivity extends AppCompatActivity {
    ImageButton menuBtn, bakBtn, homeBtn, canBtn,glassBtn, paperBtn, planstic_Btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_menu);


        bakBtn = findViewById(R.id.back_btn);
        homeBtn = findViewById(R.id.home_btn);
        menuBtn = findViewById(R.id.menu_btn);

        canBtn = findViewById(R.id.can_btn);
        glassBtn = findViewById(R.id.glass_btn);
        paperBtn = findViewById(R.id.paper_btn);
        planstic_Btn = findViewById(R.id.planstic_btn);

        canBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CanActivity.class);
                startActivity(intent);
                finish();
            }
        });
        glassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlassActivity.class);
                startActivity(intent);
                finish();
            }
        });
        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaperActivity.class);
                startActivity(intent);
                finish();
            }
        });
        planstic_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Planstic2Activity.class);
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
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EtcMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
