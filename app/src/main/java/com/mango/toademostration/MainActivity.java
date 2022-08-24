package com.mango.toademostration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText [] editTexts= new EditText[6];
    Button[] buttons= new Button[6];
    TextView[] textView= new TextView[6];
    TextView forOutPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts[0]=findViewById(R.id.editReg1);
        editTexts[1]=findViewById(R.id.editReg2);
        editTexts[2]=findViewById(R.id.editReg3);
        editTexts[3]=findViewById(R.id.editReg4);
        editTexts[4]=findViewById(R.id.editReg5);
        editTexts[5]=findViewById(R.id.editReg6);

        buttons[0]=findViewById(R.id.btnReg1);
        buttons[1]=findViewById(R.id.btnReg2);
        buttons[2]=findViewById(R.id.btnReg3);
        buttons[3]=findViewById(R.id.btnReg4);
        buttons[4]=findViewById(R.id.btnReg5);
        buttons[5]=findViewById(R.id.btnReg6);

        textView[0]=findViewById(R.id.txtReg1);
        textView[1]=findViewById(R.id.txtReg2);
        textView[2]=findViewById(R.id.txtReg3);
        textView[3]=findViewById(R.id.txtReg4);
        textView[4]=findViewById(R.id.txtReg5);
        textView[5]=findViewById(R.id.txtReg6);

        forOutPut=findViewById(R.id.txtErrorOut);

        buttons[0].setOnClickListener(v->{

             boolean b=Pattern.matches("^\\+(92)\\d{10}$",editTexts[0].getText().toString());
            RegAction(b,textView[0],forOutPut,"Follow This Format E.g +92xxxxxxxxxx");
        });

        buttons[1].setOnClickListener(v->{

             boolean b=Pattern.matches("^\\D*(YY)(\\D*)$",editTexts[1].getText().toString());
            RegAction(b,textView[1],forOutPut,"Follow This Format String Must YY in it Rest Canbe Any [a-z][A-Z]");
        });

        buttons[2].setOnClickListener(v->{

             boolean b=Pattern.matches("^(b)*|((a)(b)*(a)(b)*)*$",editTexts[2].getText().toString());
            RegAction(b,textView[2],forOutPut,"Follow This Format Lang{a,b}:String Must Have Even Number of a`s");
        });


        buttons[3].setOnClickListener(v->{

             boolean b=Pattern.matches("^(a|b)*(aa|bb)$",editTexts[3].getText().toString());
            RegAction(b,textView[3],forOutPut,"Follow This Format Lang{a,b}:String Must End with aa or bb");
        });

        buttons[4].setOnClickListener(v->{

             boolean b=Pattern.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$",editTexts[4].getText().toString());
            RegAction(b,textView[4],forOutPut,"Follow This Format abc@xyz.com");
        });

        buttons[5].setOnClickListener(v->{

             boolean b=Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}",editTexts[5].getText().toString());
            RegAction(b,textView[5],forOutPut,"Follow This Format must have 1->lower,Upper Case Letter,number,!@#$%^&* and atleast 6 Characterlong  ");
        });



    }


    void RegAction(boolean b,TextView forValid,TextView OutPut,String Error){
        if (b){
            forValid.setText("    Valid");
            forValid.setTextColor(Color.GREEN);
            OutPut.setText("Correct");
            OutPut.setTextColor(Color.GREEN);
        }
        else{
            forValid.setText("InValid");
            forValid.setTextColor(Color.RED);
            OutPut.setText(Error);
            OutPut.setTextColor(Color.RED);
        }
    }

}