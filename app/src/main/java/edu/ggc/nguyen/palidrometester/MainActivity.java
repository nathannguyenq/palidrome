package edu.ggc.nguyen.palidrometester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "Palindrome";
    private EditText input;
    private TextView tvResult;
    private ImageView ivResult;
    private FloatingActionButton fab;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello Itec 4550");

        input = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);
        ivResult = findViewById(R.id.ivResult);
        fab = findViewById(R.id.fab);
        layout = findViewById(R.id.clLayout);

        TextWatcher watcher = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String st = input.getText().toString();
                boolean result = Palindrome.check(st);
                Log.i("Palindrome", st + " palindrome status: " + result);
                if (Palindrome.check(st)) {
                    Log.i(TAG, "is a palindrome");
                    ivResult.setImageResource(R.drawable.check);
                    tvResult.setText("is a palindrome");
                } else {
                    Log.i(TAG, "is not a palindrome");
                    ivResult.setImageResource(R.drawable.x);
                    tvResult.setText("is NOT a palindrome");
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };

        input.addTextChangedListener(watcher);

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "fab clicked");
                Snackbar snackbar = Snackbar.make(layout, "Created by Nathan", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }


        });
    }
}