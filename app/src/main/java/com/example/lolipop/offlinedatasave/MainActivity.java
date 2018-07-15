package com.example.lolipop.offlinedatasave;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.databse.DatabaseManager;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.logicclass.JsonFormate;
import com.pojo.DataItem;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    @BindView(R.id.edit_personal_info_name)
    EditText personName;


    @BindView(R.id.edit_personal_info_name_date)
    EditText person_date;

    @BindView(R.id.edit_personal_info_area)
    EditText areaInfo;

    @BindView(R.id.edit_personal_info_mailing_address)
    EditText personMailingAddress;
    @BindView(R.id.edit_personal_info_city)
    EditText cityInfo;
    @BindView(R.id.edit_personal_info_mobile_number)
    EditText mobileNumber;
    @BindView(R.id.edit_personal_info_email_address)
    EditText personEmailAddress;
    @BindView(R.id.edit_personal_info_others_band)
    EditText otherBrandName;

    @BindView(R.id.edit_personal_info_spinner_gender)
    MaterialSpinner materialGender;

    @BindView(R.id.edit_personal_info_spinner_smoking_brand)
    MaterialSpinner materialSmokkingBrnad;
    public DataItem dataItem;
    public JsonFormate jsonFormate;
    DatabaseManager databaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        jsonFormate = new JsonFormate(getApplicationContext());
        databaseManager = new DatabaseManager(getApplicationContext());

        materialGender.setItems("Gender", "Male" , "Female");
        materialSmokkingBrnad.setItems( "Brand", "B&H Special Filter" , "B&H Blue Gold" , "B&H Switch" , "Others");
        dataItem = new DataItem();

        materialGender.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                if (position>0){
                    dataItem.setGenerInfo(position);
                }
            }
        });

        materialSmokkingBrnad.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                if (position>0){
                    dataItem.setSmokkingBrand(position);
                }
            }
        });


        person_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        person_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // showMyDialog();

                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            MainActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id){
            case R.id.action_settings:
                init();
                jsonFormate.getData(dataItem);
                return true;

            case R.id.action_save:
                databaseManager.createCheckList(dataItem.getPerson_name() , jsonFormate.getJson());
                return true;

            case R.id.action_show:
                Log.d("Details_data" , ""+databaseManager.getCheckList());
                Intent intent = new Intent(MainActivity.this ,  ShowActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear+1;
        String timeDate = dayOfMonth+"/"+month+"/"+year;
        person_date.setText(timeDate);
    }

    public void init(){
        if (personName.getText().toString().trim().length() > 0){
            dataItem.setPerson_name(personName.getText().toString());
        }
        if (person_date.getText().toString().trim().length() > 0){
            dataItem.setPerson_date(person_date.getText().toString());
        }
        if (areaInfo.getText().toString().trim().length() >0){
            dataItem.setArea(areaInfo.getText().toString());
        }
        if (personMailingAddress.getText().toString().trim().length() >0){
            dataItem.setMailingAddress(personMailingAddress.getText().toString());
        }
        if (cityInfo.getText().toString().trim().length() >0){
            dataItem.setCity(cityInfo.getText().toString());
        }
        if (mobileNumber.getText().toString().trim().length() >0){
            dataItem.setMobileNumber(mobileNumber.getText().toString());
        }
        if (personEmailAddress.getText().toString().trim().length() >0){
            dataItem.setEmailAddress(personEmailAddress.getText().toString());
        }

    }
}
