package com.example.menulayout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioGroupActivity extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener,
        CheckBox.OnCheckedChangeListener {

    private RadioGroup orientation;
    private RadioGroup gravity;
    private CheckBox cajita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.radio_group);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        orientation = findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        gravity = findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
        cajita = findViewById(R.id.cajita);
        cajita.setOnCheckedChangeListener(this);
    }


    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.horizontal) {
            orientation.setOrientation(LinearLayout.HORIZONTAL);
        } else if (checkedId == R.id.vertical) {
            orientation.setOrientation(LinearLayout.VERTICAL);
        }
        if (checkedId == R.id.right) {
            gravity.setGravity(Gravity.END);
        } else if (checkedId == R.id.center) {
            gravity.setGravity(Gravity.CENTER);
        } else if (checkedId == R.id.left) {
            gravity.setGravity(Gravity.START);
        }

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            cajita.setText(R.string.checked);
        } else {
            cajita.setText(R.string.not_checked);
        }
    }
}