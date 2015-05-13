package kaylamacfarlane.cuttingboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.*;


public class Conversion_Tool extends ActionBarActivity //implements AdapterView.OnItemSelectedListener
{

    private Spinner spinnerMetric, spinnerUS;
    private Button convertButton;
    private EditText userIn;
    private TextView output;
    private double userDouble;
    private double convertDouble;
    private String convertOut, UserInString;

    //private static final String[]paths1 = {"Milliliter (mL)", "Liter (L)", "Gram (g)", "Kilogram (kg)"};
    //private static final String[]paths2 = {"Teaspoon (tsp)", "Tablespoon (tbsp)", "Cup",
            //"Fluid Ounce (fl oz)", "Pint", "Quart", "Ounce (oz)", "Pound (lb)"};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion__tool);

        spinnerMetric = (Spinner)findViewById(R.id.spinnerMetric);
        //ArrayAdapter<String> adapter;

        //adapter = new ArrayAdapter(Conversion_Tool.this,
               // android.R.layout.simple_spinner_item,paths1);

        addItemsOnSpinnerUS();
        addItemsOnSpinnerMetric();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        //output=(TextView)findViewById(R.id.textView7);


        //userIn = (EditText)findViewById(R.id.editText6);
        //UserInString = (String) (userIn + "");
       // userDouble = Double.parseDouble(UserInString);


        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerMetric.setAdapter(adapter);
        //spinnerMetric.setOnItemSelectedListener(this);

    }



    public void addItemsOnSpinnerMetric() {

        spinnerMetric = (Spinner) findViewById(R.id.spinnerMetric);
        List<String> list1 = new ArrayList<String>();
        list1.add("Milliliter (mL)");
        list1.add("Liter (L)");
        list1.add("Gram (g)");
        list1.add("Kilogram (kg)");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetric.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerUS() {

        spinnerUS = (Spinner) findViewById(R.id.spinnerUS);
        List<String> list2 = new ArrayList<String>();
        list2.add("Teaspoon (tsp)");
        list2.add("Tablespoon (tbsp)");
        list2.add("Cup");
        list2.add("Fluid Ounce (fl oz)");
        list2.add("Pint");
        list2.add("Quart");
        list2.add("Ounce (oz)");
        list2.add("Pound (lb)");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUS.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinnerMetric = (Spinner) findViewById(R.id.spinnerMetric);
        spinnerMetric.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {

        spinnerMetric = (Spinner) findViewById(R.id.spinnerMetric);
        spinnerUS = (Spinner) findViewById(R.id.spinnerUS);
        convertButton = (Button) findViewById(R.id.convertButton);
       // convertOut = String.valueOf(findViewById(R.id.editText7));

        convertButton.setOnClickListener(new View.OnClickListener() {



                 @Override
                 public void onClick(View v) {

                 Toast.makeText(Conversion_Tool.this,
                  "OnClickListener : " +
                  "\nspinnerMetric : " + String.valueOf(spinnerMetric.getSelectedItem()) +
                  "\nSpinnerUS : " + String.valueOf(spinnerUS.getSelectedItem()),
                   Toast.LENGTH_SHORT).show();
                   }

                   public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {



                       switch (position) {
                       case 0:
                       // Whatever you want to happen when the first item gets selected
                     //  if (spinnerMetric.getId() == 0 && spinnerUS.getId() == 0) {
                     //      convertDouble = userDouble / 5;
                     //      convertOut = (convertDouble) + "";


                     //      output.setText(convertOut);

                           break;
                           case 1:
                           //Whatever you want to happen when the second item gets selected
                           break;
                           case 2:
                           // Whatever you want to happen when the third item gets selected
                           break;

                      }

                  }




                     // }
                      // }

                        //@Override
                          public void onNothingSelected(AdapterView<?> parent) {

                           }


                            //@Override
                            public boolean onCreateOptionsMenu(Menu menu) {
                            // Inflate the menu; this adds items to the action bar if it is present.
                            getMenuInflater().inflate(R.menu.menu_conversion__tool, menu);
                             return true;
                             }

                              //@Override
                               public boolean onOptionsItemSelected(MenuItem item) {
                                // Handle action bar item clicks here. The action bar will
                                 // automatically handle clicks on the Home/Up button, so long
                                 // as you specify a parent activity in AndroidManifest.xml.
                                 int id = item.getItemId();

                                 //noinspection SimplifiableIfStatement
                                  if (id == R.id.action_settings) {
                                      return true;
                                    }

                                   return onOptionsItemSelected(item);
                                   }
                                   }
        );
    }}

class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    //@Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }








    //@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return onOptionsItemSelected(item);
    }
}

