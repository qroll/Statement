package com.qwissroll.statement;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static int PRICE_PER_COFFEE = 5;
    int numCoffees = 0;
    boolean hasWhippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void whippedCream(View view) {
        CheckBox cb = (CheckBox) view;
        hasWhippedCream = cb.isChecked();
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void incrementOrder(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        numCoffees = Integer.parseInt(quantityTextView.getText().toString());
        numCoffees++;
        display(numCoffees);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrementOrder(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        numCoffees = Integer.parseInt(quantityTextView.getText().toString());
        numCoffees--;
        display(numCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int numCoffees = Integer.parseInt(quantityTextView.getText().toString());
        if (hasWhippedCream) {
            displayPrice(numCoffees * (PRICE_PER_COFFEE + 1));
        } else {
            displayPrice(numCoffees * (PRICE_PER_COFFEE));
        }
        Context context = getApplicationContext();
        String text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
