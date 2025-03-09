package com.soft.ieeecs_dice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int random_int;
    private Button roll_button;
    private ImageView image;
    private ArrayList<Integer> imagearray;

    Random obj = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        roll_button = findViewById(R.id.rollbutton);
        image = findViewById(R.id.imageView);

        imagearray = new ArrayList<>();
        imagearray.add(R.drawable.dice1);
        imagearray.add(R.drawable.dice2);
        imagearray.add(R.drawable.dice3);
        imagearray.add(R.drawable.dice4);
        imagearray.add(R.drawable.dice5);
        imagearray.add(R.drawable.dice6);

        image.setImageResource(imagearray.get(0));

        roll_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random_int = obj.nextInt(6);
                image.setImageResource(imagearray.get(random_int));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}