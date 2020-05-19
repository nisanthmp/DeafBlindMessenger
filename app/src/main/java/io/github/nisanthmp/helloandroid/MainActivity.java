package io.github.nisanthmp.helloandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String read_permission = Manifest.permission.RECEIVE_SMS;
        String write_permission = Manifest.permission.SEND_SMS;
        String phoneState_permission = Manifest.permission.READ_PHONE_STATE;

        requestPermission(read_permission);
        requestPermission(write_permission);
        if (Build.VERSION.SDK_INT >= 28) requestPermission(phoneState_permission);

        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                InputModule.inputString=messageText;

                Button mButton = (Button) findViewById(R.id.read_button);
                mButton.setEnabled(true);
            }
        });

        //Button button = findViewById(R.id.reader_button_1);
        //button.setBackgroundColor(0x00000000);
        //setDotsColor();
        //setDotsClickListeners();

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textview_first);
                int number = Integer.parseInt(textView.getText().toString());
                textView.setText(Integer.toString(number * 2));
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                Snackbar.make(view, "Changed number from " + number + " to " + number * 2, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         */

        //super.onCreate(savedInstanceState);

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

    private void requestPermission(String permission) {
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;

            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }
}
