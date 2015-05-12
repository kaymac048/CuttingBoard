package kaylamacfarlane.cuttingboard;

import android.app.Activity;
import android.content.Intent;
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


public class Add_Recipe extends ActionBarActivity {
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__recipe);


        EditText editText = (EditText)findViewById(R.id.Title_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        EditText editText2 = (EditText)findViewById(R.id.ptime_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        EditText editText3 = (EditText)findViewById(R.id.cTime_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        EditText editText4 = (EditText)findViewById(R.id.tTime_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        EditText editText5 = (EditText)findViewById(R.id.Ingredients_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        EditText editText6 = (EditText)findViewById(R.id.Directions_editText);
        editText.setText("", TextView.BufferType.EDITABLE);

        final Button button = (Button) findViewById(R.id.saved);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
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
