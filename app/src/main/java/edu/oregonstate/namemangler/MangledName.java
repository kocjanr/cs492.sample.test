package edu.oregonstate.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.MalformedInputException;

public class MangledName extends AppCompatActivity {

    private TextView mNameMangled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangled_name);

        Intent intent = getIntent();
        String userInputString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        mNameMangled = (TextView) findViewById(R.id.mangled_name_text);
        mNameMangled.setText(userInputString);


    }
}
