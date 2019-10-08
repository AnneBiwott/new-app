package com.example.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_menu:
                Intent home = new Intent(Options.this, Home.class);
                startActivity(home);
                break;
            case R.id.about_menu:
                Intent about = new Intent(Options.this, About.class);
                startActivity(about);
                break;
            case R.id.register_menu:
                startActivity(new Intent(Options.this,Register.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
