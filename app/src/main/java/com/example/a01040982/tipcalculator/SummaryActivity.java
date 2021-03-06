package com.example.a01040982.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.NumberFormat;

public class SummaryActivity extends AppCompatActivity {

    public TextView totalAmountToDisplay;
    public TextView splitAmountToDisplay;
    public TextView splitBetweenToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MainActivity mainActivity = new MainActivity();
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        Intent intent = getIntent();
        String totalAmount = intent.getStringExtra("TotalAmount");

        totalAmountToDisplay = (TextView) findViewById(R.id.totalAmountDisplay);
        totalAmountToDisplay.setText(totalAmount);

        String getSplitedAmount = intent.getStringExtra("SpilitedAmount");
        splitAmountToDisplay = (TextView) findViewById(R.id.splitAmountView);
        splitAmountToDisplay.setText(getSplitedAmount);

        String getSplitedBetween = intent.getStringExtra("SplitedBetween");
        splitBetweenToDisplay = (TextView) findViewById(R.id.splitedBetween);
        if(Integer.parseInt(getSplitedBetween) == 0){
            splitBetweenToDisplay.setText("None");
        }
        else{
            splitBetweenToDisplay.setText(String.valueOf(Integer.parseInt(getSplitedBetween) + 1));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(SummaryActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
