package rocknegicorporation.shpping;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Settings_Activity extends AppCompatActivity {
    private static String email = "rocknegi53@gmail.com";
    private CoordinatorLayout coordinatorLayout;

     Handler handler = new Handler(){
         @Override
         public void handleMessage(Message msg) {

         }
     };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

       coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = {email};
                Intent intent = new Intent (Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT,addresses);
                intent.putExtra(Intent.EXTRA_TEXT,addresses);
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });
    }
    public void clickbutton3(View view){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime-System.currentTimeMillis())
                        }catch (Exception E){}
                    }
                    handler.sendEmptyMessage(0);
                }

            }
        };

        Thread thread = new Thread(r);
        thread.start();



    }

    public void buttonClickHandler(View view) {
//        Toast.makeText(Settings_Activity.this, "", Toast.LENGTH_LONG).show();

    }
}


