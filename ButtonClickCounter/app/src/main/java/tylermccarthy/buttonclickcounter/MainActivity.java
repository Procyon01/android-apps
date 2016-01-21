package tylermccarthy.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This is code for displaying the contents to the android screen
        // This calls android code to go ahead and do so
        setContentView(R.layout.activity_main);

        //Now that setContentView has been called we can link to our active elements
        ourButton = (Button) findViewById(R.id.cookie_clicker);
        ourMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener ourClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                ourMessage.setText("TIMES PRESSED: " + clickCount);
            }
        };

        ourButton.setOnClickListener(ourClickListener);
        //TODO figure out what this is all about
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Is this the mail icon or something else?
        // It is!
        /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });  */
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
            Toast toastMessage = Toast.makeText(this, "The settings menu option was tapped", Toast.LENGTH_LONG);
            toastMessage.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
