package rocknegicorporation.shpping;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MENU_ITEM_LOGOUT = 1001;
    private CoordinatorLayout coordinatorLayout;

    private static String  webUrl = "https://github.com/rocknegi/Assassins_creed/tree/master";
    private static String email = "rocknegi53@gmail.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0,MENU_ITEM_LOGOUT,103, R.string.logout);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        LinearLayout content_layout = (LinearLayout) findViewById(R.id.content_layout);

        switch (id){

            case R.id.action_about:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_contact_me:
                Intent intent2 = new Intent(this,contact.class);
                startActivity(intent2);
                return true;

            case MENU_ITEM_LOGOUT:
                Snackbar.make(coordinatorLayout,"you selected logout",Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;

            case R.id.action_wallpapers:
                Snackbar.make(coordinatorLayout,"Coming soon",Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;

            case R.id.action_cart:
                Snackbar.make(coordinatorLayout,"MOTO: Nothing Is True Everything Is Permitted",Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;

            case R.id.action_web:
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                if (webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                    return true;
                }
            case R.id.action_settings:
                Intent intent3 = new Intent(this,Settings_Activity.class);
                startActivity(intent3);
                return true;

            case R.id.menu_red:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                content_layout.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_green:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                content_layout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_yellow:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                content_layout.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_default:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                content_layout.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.menu_dark:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                content_layout.setBackgroundColor(Color.BLACK);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}