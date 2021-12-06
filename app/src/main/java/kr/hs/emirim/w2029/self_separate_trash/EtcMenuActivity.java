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

        foodBtn = findViewById(R.id.planstic_btn);
        plansticBtn = findViewById(R.id.dress_btn);
        dressBtn = findViewById(R.id.styrofoam_btn);
        styrofoamBtn = findViewById(R.id.food_btn);

        foodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent3);
                finish();
            }
        });
        plansticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), PlansticActivity.class);
                startActivity(intent3);
                finish();
            }
        });
        dressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), DressActivity.class);
                startActivity(intent3);
                finish();
            }
        });
        styrofoamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), StyrofoamActivity.class);
                startActivity(intent3);
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
                Intent intent2 = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
