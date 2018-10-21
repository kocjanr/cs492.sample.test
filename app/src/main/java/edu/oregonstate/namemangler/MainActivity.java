package edu.oregonstate.namemangler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private EditText mUserInput;
    private Button mMangleButton;
    private String[] names = {"Jones", "Bob", "Worthington", "Hollywood"};

    public static final String EXTRA_MESSAGE = "edu.oregonstate.namemangler.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.first_name_text);

        mMangleButton = (Button) findViewById(R.id.submit_button);
        mMangleButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Editable edit = mUserInput.getText();
                String userInputString = edit.toString();

                if (userInputString.length() == 0){
                    Context context = getApplicationContext();
                    CharSequence output = "Please enter a name";
                    Toast toast = Toast.makeText(context,output,LENGTH_SHORT);
                    toast.show();
                } else{
                    //Random rand = new Random();
                    //int randomNum = rand.nextInt((0 - 3) + 1) + 0;

                    Intent intent = new Intent(MainActivity.this, MangledName.class);
                    intent.putExtra(EXTRA_MESSAGE, userInputString);
                    startActivity(intent);

//                    Context context = getApplicationContext();
//                    CharSequence output = "Please enter a name";
//                    Toast toast = Toast.makeText(context,userInputString,LENGTH_SHORT);
//                    toast.show();
                }
            }
        });
    }
}