package kr.hs.emirim.w2029.self_separate_trash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EtcMenuActivity extends AppCompatActivity {
    ImageButton backBtn, homeBtn, menuBtn, foodBtn, plansticBtn, dressBtn, styrofoamBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_etc_menu);

        backBtn = findViewById(R.id.back_btn);
        homeBtn = findViewById(R.id.home_btn);
        menuBtn = findViewById(R.id.menu_btn);

        foodBtn = findViewById(R.id.food_btn);
        plansticBtn = findViewById(R.id.planstic_btn);
        dressBtn = findViewById(R.id.dress_btn);
        styrofoamBtn = findViewById(R.id.styrofoam_btn);

        foodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent);
                finish();
            }
        });
        plansticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlansticActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DressActivity.class);
                startActivity(intent);
                finish();
            }
        });
        styrofoamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StyrofoamActivity.class);
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
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
