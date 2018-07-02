package com.alisha.tasbeeh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button btnCount, btnReset;
    TextView disp;
    ImageView img;
    Vibrator vibe;
    int masterCount;
    int slaveCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp = (TextView)findViewById(R.id.textView);
        img = (ImageView)findViewById(R.id.imageView);
        vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        btnReset = (Button)findViewById(R.id.btnreset);
        btnCount = (Button)findViewById(R.id.btncount);

        masterCount = 0;
        slaveCount = 0;

        img.setImageResource(R.drawable.allahoakbar);
    }

    public void count(View v)
    {
        slaveCount = Integer.parseInt(disp.getText().toString());

        if (masterCount == 34)
        {
            img.setImageResource(R.drawable.alhamdolillah);
            disp.setText("1");
            slaveCount = 0;
            vibe.vibrate(100);
            masterCount++;
            return;
        }

        else if (masterCount == 67)
        {
            img.setImageResource(R.drawable.subhanallah);
            disp.setText("1");
            slaveCount = 0;
            vibe.vibrate(100);
            masterCount++;
            return;
        }

        else if (masterCount == 100)
        {
            completeAlert();
            img.setImageResource(R.drawable.allahoakbar);
            disp.setText("0");
            slaveCount = 0;
            vibe.vibrate(100);
            masterCount = 0;
            return;
        }

        disp.setText(String.valueOf(slaveCount+1));
        masterCount++;
    }

    public void completeAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Completed!");
        builder.setMessage("Tasbeeh completed. Do you want to start again?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void reset(View v)
    {
        img.setImageResource(R.drawable.allahoakbar);
        disp.setText("0");
        slaveCount = 0;
        masterCount = 0;
        vibe.vibrate(100);
    }
}
