package rocknegicorporation.shpping;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class Settings_Activity extends AppCompatActivity {
    private static String email = "rocknegi53@gmail.com";
    CoordinatorLayout coordinatorLayout;


    MyService rocksService;
    boolean isBound = false;


    public void showTime(View view){
        String currentTime = rocksService.getCurrentTime();
        TextView rocksText = (TextView) findViewById(R.id.rocksText);
        rocksText.setText(currentTime);
    }

    private ServiceConnection rocksConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service;
            rocksService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        Intent i = new Intent(this,MyService.class);
        bindService(i,rocksConnection, Context.BIND_AUTO_CREATE);

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









}


