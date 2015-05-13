package kaylamacfarlane.cuttingboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Recipe_Box extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__box);

        final Button button = (Button) findViewById(R.id.ButtonLoadRecipe);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
          //  Add_Recipe AR = new Add_Recipe();
              //  AR.onCreate(fileList());

                /*File fileStuff = getFileStreamPath(fileTest);
                if (fileText.exists()) {
                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new FileReader(fileStuff));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    assert in != null;
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe__box, menu);
        return true;
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
