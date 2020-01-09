package com.example.studentwsb.aplikacja;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_manu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.english:
                setLanguage("english");
                return true;
            case R.id.spanish:
                setLanguage("spanish");
                return true;
                default:
                    return false;
        }



    }

    public void setLanguage(String language){

        sharedPreferences.edit().putString("language",language).apply();
        textView.setText(language);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.studentwsb.aplikacja",Context.MODE_PRIVATE);


        String language = sharedPreferences.getString("language", "Error");
        if(language.equals("Error")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Choose a language")
                    .setMessage("Whitch language would you like?")
                    .setPositiveButton("SPANISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //ustaw jezyk hiszpaniski
                            setLanguage("spanish");

                        }
                    })
                    .setNegativeButton("ENGLISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //ustaw jezyk hiszpaniski
                            setLanguage("english");

                        }
                    })
                    .show();
        }else{
            textView.setText(language);
        }
    }
}
