package kaylamacfarlane.cuttingboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Add_Recipe extends ActionBarActivity {
    private static final int SELECT_PICTURE = 1;
    /*private static final String RecipeFile = "RecipeEntry";
    String FILENAME = "fileTest";
    FileOutputStream fos = openFileOutput(RecipeFile, Context.MODE_PRIVATE);
    fos.write(storeRecipe.getBytes());
    fos.close();*/


    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__recipe);

      //  SharedPreferences recipeStuff = getSharedPreferences(RecipeFile, MODE_PRIVATE);
      //  SharedPreferences.Editor prefEditor = recipeStuff.edit();

        final Button button = (Button) findViewById(R.id.ButtonSendRecipe);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                File file = new File("/sdcard/storage/sample.txt");
                String String = "testTest";
                String FILENAME = "testTest";

                final EditText RecipeTitle = (EditText) findViewById(R.id.Title_editText);
                String Title = RecipeTitle.getText().toString();
               // Intent intent = new Intent(Add_Recipe.this,GetText.class);

                final EditText PrepTime = (EditText) findViewById(R.id.PrepTime_editText);
                String Prep = PrepTime.getText().toString();

                final EditText CookTime= (EditText) findViewById(R.id.cTime_editText);
                String Cook = CookTime.getText().toString();

                final EditText TotalTime = (EditText) findViewById(R.id.tTime_editText);
                String Total = TotalTime.getText().toString();

                final EditText Ingredients = (EditText) findViewById(R.id.Ingredients_editText);
                String Ingr = Ingredients.getText().toString();

                final EditText Directions = (EditText) findViewById(R.id.Directions_editText);
                String Dir = Directions.getText().toString();


                System.out.println(Title + " "+ Prep +" "+ Cook+ " "+ Total+ " "+ Ingr);
                try (FileOutputStream fop = new FileOutputStream(file)){
                    if(!file.exists()){
                        file.createNewFile();
                    }

                  //  FileOutputStream fos = openFileOutput(file, Context.MODE_WORLD_READABLE);
                    fop.write(Title.getBytes());
                    fop.write(Prep.getBytes());
                    fop.write(Cook.getBytes());
                    fop.write(Total.getBytes());
                    fop.write(Ingr.getBytes());

                    System.out.println(file);
                    fop.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        ((ImageButton) findViewById(R.id.imageButton))
                .setOnClickListener(new View.OnClickListener() {

                    public void onClick(View arg0) {

                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent,
                                "Select Picture"), SELECT_PICTURE);
                    }
                });
    }
   /* public void storeRecipe(View button)
    {
        String FILENAME = "fileTest";
        String String = "testTest";

        final EditText RecipeTitle = (EditText) findViewById(R.id.Title_editText);
        String Title = RecipeTitle.getText().toString();

        final EditText PrepTime = (EditText) findViewById(R.id.PrepTime_editText);
        String Prep = PrepTime.getText().toString();

        final EditText CookTime= (EditText) findViewById(R.id.cTime_editText);
        String Cook = CookTime.getText().toString();

        final EditText TotalTime = (EditText) findViewById(R.id.tTime_editText);
        String Total = TotalTime.getText().toString();

        final EditText Ingredients = (EditText) findViewById(R.id.Ingredients_editText);
        String Ingr = Ingredients.getText().toString();

        System.out.println(Title + " "+ Prep +" "+ Cook+ " "+ Total+ " "+ Ingr);
        try {
            FileOutputStream fos = openFileOutput(FILENAME,Context.MODE_PRIVATE);
            fos.write(Title.getBytes());
            fos.write(Prep.getBytes());
            fos.write(Cook.getBytes());
            fos.write(Total.getBytes());
            fos.write(Ingr.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    private static int RESULT_LOAD_IMG = 1;
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
        // When an Image is picked
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                && null != data) {

            Uri selectedImage = data.getData();

            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();

            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail=BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));

            ImageButton mImageButton;
            mImageButton = (ImageButton) findViewById(R.id.imageButton);
            mImageButton.setImageBitmap(thumbnail);
            Toast.makeText(this, "Image selected.",
                    Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }
    } catch (Exception e) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                .show();
    }

    }
    public String getPath(Uri uri) {
       if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }

        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }

        return uri.getPath();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add__recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
