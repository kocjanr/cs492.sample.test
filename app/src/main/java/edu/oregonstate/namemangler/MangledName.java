package edu.oregonstate.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MangledName extends AppCompatActivity {
    private String[] names = {"Jones", "Bob", "Worthington", "Hollywood"};
    private TextView mNameMangled;
    private Button mResetButton;
    private Button mRemangleButton;

    private static final String ARRAY_INDEX = "index";
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangled_name);

        if(savedInstanceState !=null){
            value = savedInstanceState.getInt(ARRAY_INDEX,0);
        }

        Intent intent = getIntent();
        final String userInputString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Random rand = new Random();
        value = rand.nextInt(names.length) + 1;
        String mangledDisplayName = userInputString + " " + names[value];

        mNameMangled = (TextView) findViewById(R.id.mangled_name_text);
        mNameMangled.setText(mangledDisplayName);

        mResetButton = (Button) findViewById(R.id.reset_button);
        mResetButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mNameMangled.setText(userInputString);
            }
        });

        mRemangleButton = (Button) findViewById(R.id.remangle_button);
        mRemangleButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MangledName.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(ARRAY_INDEX,value);

    }
}
