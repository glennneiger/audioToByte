package com.example.loki.audiobyte;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class MainActivity extends ActionBarActivity {
    Button but1;
    String in1,in2,in3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in1= "hey how ru";
        Log.e("String", "value is : " + in1);

        Context context = getApplicationContext();
        CharSequence text1 = "welcome!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text1, duration);
        toast.show();


        but1=(Button) findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(v);

                in2= "Start now";
                Log.e("String", "value is : " + in2);

            }
        });

    }

     public void action(View view) {
         byte[] buffer1 ;
            try {

               //Opening the audio byte text file
                File root = android.os.Environment.getExternalStorageDirectory();
                File dir = new File(root.getAbsolutePath() + "/download");
                dir.mkdirs();
                File file1 = new File(dir, "Sugar123.txt");

                FileInputStream fis = new FileInputStream(file1);

                //Creating Media Player object
                MediaPlayer mp = new MediaPlayer();

                //Feeding the text file byte data into the Media Player
                mp.setDataSource(fis.getFD());
                mp.prepare();
                mp.start();

            } catch (IOException ex) {
                String s = ex.toString();
                ex.printStackTrace();
            }



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

