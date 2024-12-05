package com.example.menulayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.search.SearchBar;

public class Menu extends AppCompatActivity {
    public void cambiarActividad(View view){
        Class claseACambiar = null;
        if (view.getId() == R.id.radio_button){
            claseACambiar = RadioGroupActivity.class;
        } else if (view.getId() == R.id.weight_layout) {
            claseACambiar = WeightActivity.class;
        }
        else if (view.getId() == R.id.search_bar) {
            claseACambiar = Search.class;
        }
        else if (view.getId() == R.id.overlap) {
            claseACambiar = Overlap.class;
        }
        else if (view.getId() == R.id.form){
            claseACambiar = Form.class;
        }
        Intent newActivity = new Intent(this, claseACambiar);
        Menu.this.startActivity(newActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }


}
