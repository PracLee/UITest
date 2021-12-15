package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // get InputBox
    private EditText ev_input;

    // get Button
    private Button btn_input;
    private Button btn_print;
    private Button btn_log;
    private Button btn_toast;
    private Button btn_alert;

    // get TextView
    private TextView tv_input;
    private TextView tv_change;
    private TextView tv_result;

    // get ToggleButton
    private ToggleButton tb_change;

    // get Switch
    private Switch sw_change;

    // get CheckBox
    private CheckBox cb_change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ev_input = findViewById(R.id.ev_input);
        btn_input = findViewById(R.id.btn_input);
        tv_input = findViewById(R.id.tv_input);
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // callback method
                String input = ev_input.getText().toString();   // getText == Object
                tv_input.setText(input);
            }
        });

        tv_change = findViewById(R.id.tv_change);
        tb_change = findViewById(R.id.tb_change);

        // changeListener Object
        tb_change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tv_change.setText("On My TB");
                    tv_change.setBackgroundColor(Color.GREEN);
                }
                else{
                    tv_change.setText("Off My TB");
                    tv_change.setBackgroundColor(Color.RED);
                }
            }
        });

        sw_change = findViewById(R.id.sw_change);
        sw_change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sw_change.setText("ON My SW");
                    sw_change.setBackgroundColor(Color.GREEN);
                }
                else{
                    sw_change.setText("ON My SW");
                    sw_change.setBackgroundColor(Color.RED);
                }
            }
        });

        cb_change = findViewById(R.id.cb_change);
        cb_change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sw_change.setText("ON My CB");
                    sw_change.setBackgroundColor(Color.GREEN);
                }
                else{
                    sw_change.setText("ON My CB");
                    sw_change.setBackgroundColor(Color.RED);
                }
            }
        });

        btn_print = findViewById(R.id.btn_print);
        tv_result = findViewById(R.id.tv_result);
        btn_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = ev_input.getText().toString();
                boolean isTbChecked = tb_change.isChecked();
                boolean isSwChecked = sw_change.isChecked();
                boolean isCbChecked = cb_change.isChecked();

                String result = "EditText : " + input + "\n" + "ToggleButton : " + isTbChecked + "\n" + "Switch : " + isSwChecked + "\n" + "CheckBox : " + isCbChecked;

                tv_result.setText(result);
            }
        });

        btn_log = findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("###Debug###", "Debug");    // debug message
                Log.i("###Info###", "Info");    // info message
                Log.e("###Error###", "Erorr");    // error message
                Log.w("###Warning###", "Warning");    // warning message
                Log.v("###Verbose###","Verbose");    // verbose message
            }
        });

        btn_toast = findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"ToastTest!",Toast.LENGTH_SHORT).show();
            }
        });

        btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Alert Title!");
                builder.setMessage("Alert Text");
                builder.setNeutralButton("NaturalBtn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Natural Click", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("PositiveBtn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Positive Click" ,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NegativeBtn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Negative Click",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);   // Alert Close False
                builder.show();
            }
        });
    }
}