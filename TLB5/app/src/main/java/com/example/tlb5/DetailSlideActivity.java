package com.example.tlb5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSlideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hotel_activity);

        ImageView imageView = findViewById(R.id.detailSlideImage);
        TextView ocnekaHotel = findViewById(R.id.txtSlideocenka);
        TextView timeHotel = findViewById(R.id.textSlideTime);
        TextView titleHotel = findViewById(R.id.titleSlideTime);
        TextView titleStreet = findViewById(R.id.txtSlideStreet);

        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("image", 0));
        titleHotel.setText(intent.getStringExtra("title"));
        titleStreet.setText( "Адрес: " + intent.getStringExtra("street"));
        timeHotel.setText( "Пн - Вс: " + intent.getStringExtra("time"));
        ocnekaHotel.setText( "Рейтинг: " + intent.getStringExtra("reit"));
    }
}
