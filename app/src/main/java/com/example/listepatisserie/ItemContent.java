package com.example.listepatisserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemContent extends AppCompatActivity {

    ImageView img;
    TextView name;
    TextView prix;
    TextView detail;
    Button button;

    final String EXTRA_ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_ListePatisserie);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_content);

        Drawable[] drawables = {
                getDrawable(getResources().getIdentifier("black_forest","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("cookie","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("crepe","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("croissant","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("donut","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("eclair","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("macarons","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("muffin","drawable",getPackageName())),
                getDrawable(getResources().getIdentifier("palmier","drawable",getPackageName())),
        };

        img = findViewById(R.id.imgDetail);
        name = findViewById(R.id.nameDetail);
        prix = findViewById(R.id.prixDetail);
        detail = findViewById(R.id.contentDetail);
        button = findViewById(R.id.button);

        Intent intent = getIntent();
        Patisserie patisserie = intent.getParcelableExtra(EXTRA_ITEM);

        img.setImageDrawable(drawables[patisserie.getId()]);
        name.setText(patisserie.getName());
        String prixTxt = "Prix : "+patisserie.getPrix()+" €";
        prix.setText(prixTxt);
        detail.setText(patisserie.getDetail());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ItemContent.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}