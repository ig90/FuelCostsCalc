package f.igor.ilezawache;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void doCalc (View v){

        double d_km = 0;
        try {
            EditText inputKm = (EditText) findViewById(R.id.inputKm);
            String km_num = inputKm.getText().toString();
            d_km = Double.parseDouble(km_num);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        double d_fuelPrice = 0;
        try {
            EditText fuelPrice = (EditText) findViewById(R.id.inputPrice);
            String fuelPrice_txt = fuelPrice.getText().toString();
            d_fuelPrice = Double.parseDouble(fuelPrice_txt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        double d_consumption = 0;
        try {
            EditText consumption = (EditText) findViewById(R.id.inputConsumption);
            String consumption_txt = consumption.getText().toString();
            d_consumption = Double.parseDouble(consumption_txt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int i_people =1;
        try {
            EditText people = (EditText) findViewById(R.id.inputPeople);
            String people_txt = people.getText().toString();
            i_people = Integer.parseInt(people_txt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        double result;
        result = (d_fuelPrice*d_consumption) * (d_km/100);
        result = result/i_people;
        TextView tv = (TextView) findViewById(R.id.outputResult);

        String curr = " PLN";
        String res = String.valueOf(result);
        tv.setText(res + curr);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
