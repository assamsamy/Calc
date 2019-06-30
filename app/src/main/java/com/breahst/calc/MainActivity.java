package com.breahst.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView resultat;
    Button clear, cancel, b0,b1,b2,b3,b4,b5,b6,b7,b8,b9, equals, minus, plus, mult, div, dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultat = findViewById(R.id.result);

        clear = findViewById(R.id.clear);
        cancel = findViewById(R.id.cancel);
        equals = findViewById(R.id.eq);
        minus = findViewById(R.id.minus);
        mult = findViewById(R.id.mult);
        dot = findViewById(R.id.dot);
        div = findViewById(R.id.div);
        plus = findViewById(R.id.plus);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

       cancel.setOnClickListener(new calc(resultat));
       minus.setOnClickListener(new calc(resultat));
       mult.setOnClickListener(new calc(resultat));
       dot.setOnClickListener(new calc(resultat));
       div.setOnClickListener(new calc(resultat));
       plus.setOnClickListener(new calc(resultat));

       b0.setOnClickListener(new calc(resultat));
       b1.setOnClickListener(new calc(resultat));
       b2.setOnClickListener(new calc(resultat));
       b3.setOnClickListener(new calc(resultat));
       b4.setOnClickListener(new calc(resultat));
       b5.setOnClickListener(new calc(resultat));
       b6.setOnClickListener(new calc(resultat));
       b7.setOnClickListener(new calc(resultat));
       b8.setOnClickListener(new calc(resultat));
       b9.setOnClickListener(new calc(resultat));



    }



}
class calc implements View.OnClickListener {
    TextView result;

    calc(TextView result){

        this.result = result;
        result.setText(R.string.result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:{
                result.setText(R.string.result);
                break;
            }
            //todo equals et clear
            default:{

                result.append(((Button) v).getText() );
                break;
            }

        }
    }
}
