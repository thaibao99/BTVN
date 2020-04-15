package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    EditText editText;
    TextView txt;
    Button btn;

String ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

    }

    private void setupUI() {
        spinner = findViewById(R.id.planets_spinner_output);
        editText = findViewById(R.id.edt_input);
        txt = findViewById(R.id.output);
        btn= findViewById(R.id.btn);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //  Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        ((TextView) parent.getChildAt(0)).setTextSize(20);
        ten=parent.getItemAtPosition(position).toString();

    }


    public  void giaitr(String ten ){
        if(ten.equals("Mỹ")){
            int i=Integer.parseInt(editText.getText().toString());
            float kq= (float) (i* 0.000043);
            txt.setText(""+kq +"USA");
        }
        if(ten.equals("Hàn Quốc")){
            int i=Integer.parseInt(editText.getText().toString());
            float kq= (float) (i* 0.00005080);
            txt.setText(""+kq +"KRW");
        }
        if(ten.equals("Nhật")){
            int i=Integer.parseInt(editText.getText().toString());
            float kq= (float) (i* 1/206);
            txt.setText(""+kq+ "Y");
        }
        if(ten.equals("Anh")){
            int i=Integer.parseInt(editText.getText().toString());
            float kq= (float) (i* 0.68/20000);
            txt.setText(""+kq+"GBP");
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        giaitr(ten);
    }
}
