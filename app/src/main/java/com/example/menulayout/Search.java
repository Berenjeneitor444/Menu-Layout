package com.example.menulayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.net.UriCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = ((EditText)findViewById(R.id.entry)).getText().toString();
                if(!query.isEmpty()){

                    Uri uri = Uri.parse(query);
                    if (!(uri.getScheme() == null)){
                        Intent gugle = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(gugle);
                    }
                    // si no es una url valida, asumo que es una busqueda en google y la lanzo
                    else{
                        String busqueda = "https://www.google.com/search?q=" + Uri.encode(query);
                        Intent gugle = new Intent(Intent.ACTION_VIEW, Uri.parse(busqueda));
                        startActivity(gugle);
                    }

                }
            }
        });
    }


}