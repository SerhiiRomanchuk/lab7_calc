package io.labs.lab7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import io.first.androlab7.R;


public class MainActivity extends AppCompatActivity {

    private String lastExpression;
    private String input;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input="";

        findViewById(R.id.button1).setOnClickListener(view->{
            addInput("1");
        });
        findViewById(R.id.button2).setOnClickListener(view->{
            addInput("2");
        });
        findViewById(R.id.button3).setOnClickListener(view->{
            addInput("3");
        });
        findViewById(R.id.button4).setOnClickListener(view->{
            addInput("4");
        });
        findViewById(R.id.button5).setOnClickListener(view->{
            addInput("5");
        });
        findViewById(R.id.button6).setOnClickListener(view->{
            addInput("6");
        });
        findViewById(R.id.button7).setOnClickListener(view->{
            addInput("7");
        });
        findViewById(R.id.button8).setOnClickListener(view->{
            addInput("8");
        });
        findViewById(R.id.button9).setOnClickListener(view->{
            addInput("9");
        });
        findViewById(R.id.button0).setOnClickListener(view->{
            addInput("0");
        });

        findViewById(R.id.buttonMultiply).setOnClickListener(view->{
            addInput("*");
        });
        findViewById(R.id.buttonDivide).setOnClickListener(view->{
            addInput("/");
        });
        findViewById(R.id.buttonPlus).setOnClickListener(view->{
            addInput("+");
        });
        findViewById(R.id.buttonMinus).setOnClickListener(view->{
            addInput("-");
        });
        findViewById(R.id.buttonLeftBracket).setOnClickListener(view->{
            addInput("(");
        });
        findViewById(R.id.buttonRightBracket).setOnClickListener(view->{
            addInput(")");
        });
        findViewById(R.id.buttonDot).setOnClickListener(view->{
            addInput(".");
        });
        findViewById(R.id.buttonC).setOnClickListener(view->{
            input="";
            addInput("");
        });

        findViewById(R.id.buttonResult).setOnClickListener(view->{
            TextView tv = findViewById(R.id.input);
            lastExpression=tv.getText().toString();
            Expression exp = new ExpressionBuilder(tv.getText().toString()).build();
            double result = 0;
            try{
                result = exp.evaluate();
            } catch (Exception e){}
            input = ""+result;
            tv.setText(input);
        });

    }

    public void onMenuBackClicked(MenuItem menuItem){
        if(input.length()>0){
            input=input.substring(0,input.length()-1);
            addInput("");
        }
    }

    public void onMenuCancelClicked(MenuItem menuItem){
        if(lastExpression!=null){
            input=lastExpression;
            addInput("");
        }
    }

    public void onMenuAboutClicked(MenuItem menuItem){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Про автора").setMessage("Романчук Сергій, ІПЗ-17-1")
                .create().show();
    }

    public void onMenuInstructionClicked(MenuItem menuItem){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Інструкція").setMessage("Введіть необхідний вираз щоб порахувати "+
                "результат.\nЩоб стерти символ, натисніть кнопку відмнити в менюю. Для повернення "+
                "виразу, натисніть кнопку повернути")
                .create().show();
    }

    private void addInput(String value) {
        input=input.concat(value);
        TextView tv = findViewById(R.id.input);
        tv.setText(input);
    }
}
