package com.kassam.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

// 1. Implement an interface (View.OnClickListener) which allows us to handle on click events on our calendar picker
//    dialog

//7. Implement an interface (AdapterView.onItemSelectedListener)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
//2. Declare an EditText variable that is the focus on the calendar dialog
    private EditText birthday;
    //5. Declare the variables to hold the selected date (YEAR, MONTH AND DAY)
    private int mYear, mMonth, mDay;

    //7.6 Declare a variable for holding the item selected on the spinner
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3. Connect the Edit Text variable with the one specified in the layout for receiving the date value.
        birthday = findViewById(R.id.birthday);
        //4. Connect the EditText variable with an OnClick Listener
        birthday.setOnClickListener(this);
        //7.1 Declare a spinner variable and connect it with the spinner view in the layout
        Spinner phoneSpinner = findViewById(R.id.phone_spinner);
        //7.2 Set an onItemSelectedListener on the spinner object/variable you have created
        if(phoneSpinner != null){
            phoneSpinner.setOnItemSelectedListener(this);
        }
        //7.3 Create an array adapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_label, android.R.layout.simple_spinner_item);
        //7.4 Specify the layout for dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //7.5 Attach the spinner to the adapter
        if (phoneSpinner != null) {
            phoneSpinner.setAdapter(adapter);
        }

    }


    @Override
    public void onClick(View v) {
        //6. To get the instance of the current date
        //6.1 Ensure the focus is on the Edit variable birthday

        if(v == birthday){
            //6.2 Declare the calendar to get the current selected date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            //6.3 Declare a date picker dialog to pick the selected date
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //6.4 set the date on the edit text dialog
                    birthday.setText(dayOfMonth +"-"+ (month+1) +"-"+ year);
                }
            }, mYear, mMonth, mDay);
            //6.5 Show the datepicker dialog
            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //changing the text color for the spinner elements
        ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
        //7.7 Use the method getItemAtPosition() to get the label selected
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        //7.8 Something to do with item selected
        Toast myToast = Toast.makeText(this, "Selected Phone as:" + mSpinnerLabel, Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //7.9 Something to do
        Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
    }

    public void showToast(View view) {
        Toast.makeText(this, "Please Accept Terms and Conditions", Toast.LENGTH_SHORT).show();
    }

    public void createAccount(View view) {
        //Compare Passwords

        //Throw Error Exemptions

        //Get the data entered on editext and save it on a database

        //add intent and open main Activity/Login Activity

        //Throw a toast
        Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_SHORT).show();
    }
}