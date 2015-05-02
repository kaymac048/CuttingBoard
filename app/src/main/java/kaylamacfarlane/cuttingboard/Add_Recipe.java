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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Add_Recipe extends ActionBarActivity {
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__recipe);


        ((ImageButton) findViewById(R.id.imageButton))
                .setOnClickListener(new View.OnClickListener() {

                    public void onClick(View arg0) {

                        // in onCreate or any event where your want the user to
                        // select a file
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
            // Get the Image from data

            //here you grab the data
            Uri selectedImage = data.getData();
            //get the path to wherever the image was stored
            String[] filePath = {MediaStore.Images.Media.DATA};

            //i have no idea what this does, just do it
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            //same as above
            c.moveToFirst();

            //just trust me lol
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail=BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));
            //This thumbnail object now contains your image!
       //     Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            //ignore this one
           // img = thumbnail;

            //I have an imageview on my UI, and these three lines display the image I just picked on that ImageView.
            //If you use a button it's probably slightly different, look into it if you need
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
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            //imageButton.setImageBitmap(imageBitmap);
//
//            ImageButton i = (ImageButton) findViewById(R.id.imageButton);
//            i.setImageBitmap(imageBitmap);
//
//        }
//    }



      //  if (resultCode == RESULT_OK) {

//            if (requestCode == SELECT_PICTURE) {
//                Uri selectedImageUri = data.getData();
//                selectedImagePath = getPath(selectedImageUri);
//
//                Bundle b = new Bundle();
//                Intent i = getIntent(); //gets the intent that called this intent
//                i.putExtras(b);
//                setResult(Activity.RESULT_OK, i);
//                finish();
         //   }
         //   }
        //   }
    public String getPath(Uri uri) {
        // just some safety built in
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }
//    Uri selectedImageUri = data.getData();
//    //In the following code, I'm trying to get
//    //the path for the image file
//    try {
//        imageBMP = null;
//        String selectedImagePath = getPath(selectedImageUri);
//        if (selectedImagePath != null) {
//            filePath = selectedImagePath;
//            //Potentially long-running tasks must be put on their own
//            //thread.
//            Thread DecodeRunnable = new Thread(new Runnable(){
//                public void run() {
//                    decodeFile();
//                }
//            });
//            DecodeRunnable.start();
//        }
//    }//try
//
//    public void decodeFile() {
//        //This method decodes the file from base 64 to base 32,
//        //which allows us to manipulate it as a bitmap in android.
//
//        BitmapFactory.Options o = new BitmapFactory.Options();
//        //This option lets us create a bitmap without the extra
//        //overhead of allocating new memory for data on its pixels
//        o.inJustDecodeBounds = true;
//
//        //If you see this error, then darkness has befallen us.
//        if(BitmapFactory.decodeFile(selectedImagePath, o) == null){
//            Log.d("DECODING: ", "Error! The file is null in the decoding code!");
//        }
//
//        BitmapFactory.Options o2 = new BitmapFactory.Options();
//        //This option will scale the file. There's no need to get the full-sized
//        //image, since it could crash the app if its size exceeds the memory in
//        //the heap (It's Java's fault, not mine.)
//        o2.inSampleSize = 2;
//        imageBMP = BitmapFactory.decodeFile(selectedImagePath, o2);
//
//        //The following code will set the image view that the user sees. That
//        //has to be run on the ui thread.
//        runOnUiThread(new Runnable(){
//            public void run(){
//                if (imageBMP != null) {
//                    Bitmap imageViewBMP = null;
//                    //Scale the image if necessary so it doesn't fill the entire
//                    //app view, which it will do if it's big enough.
//                    if(imageBMP.getWidth() > 175 && imageBMP.getHeight() > 200){
//                        imageViewBMP = Bitmap.createScaledBitmap(imageBMP, 200, 200,
//                                true);
//                    }
//                    else{
//                        imageViewBMP = imageBMP;
//                    }
//                    imageViewIV.setImageBitmap(imageViewBMP);
//                }//if(imageBMP != null)
//                else{
//                    Resources res = getResources();
//                    imageViewIV.setImageDrawable( res.getDrawable(R.drawable.noimage) );
//                    photoStatusTV.setText(R.string.no_photo_text);
//                    Toast.makeText(getApplicationContext(), "No image found.",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//    }//decodeFile()
//



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add__recipe, menu);
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
