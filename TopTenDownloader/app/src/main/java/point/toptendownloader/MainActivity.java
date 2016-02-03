package point.toptendownloader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
This code highly resembles code done by Tim Buchalka in the Udemy course "Master
Android 6.0 Marshmallow Apps Development Using Java". This is because, as part
of the course, I am following along with his code.

Concepts and structures put into practice herein:
    AsyncTask
    Permissions

 */


public class MainActivity extends AppCompatActivity {

    private String fileContents;
    private Button btnParse;
    private ListView listApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = (Button) findViewById(R.id.btnParse);
        listApps = (ListView) findViewById(R.id.listApps);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseApplications parseApplications = new ParseApplications(fileContents);
                parseApplications.process();
            }
        });

        // Get XML file
        DownloadData dlData = new DownloadData();
        dlData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");
    }

    public class DownloadData extends AsyncTask<String, Void, String>{
        // Second param of AsyncTask is typically progress bar. Leaving for now

        @Override
        protected String doInBackground(String... params) {
            // "String... params": new in java, represents variable number of params in array

            fileContents = downloadXML(params[0]);
            if (fileContents == null){
                Log.d("DownloadData", "Error downloading item");
            }
            return fileContents;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("DownloadData", "Result: " + result);

            // Add XML to view on screen
            // Note: onPostExecute is where ALL UI element updates should be done for AsyncTask
            // Tim Buchalka: you will get errors if trying to do so from another method.
            //xmlView.setText(fileContents);
        }

        // Download XML file representing the top ten apps XML feed
        private String downloadXML(String urlPath){
            StringBuilder xmlFileBuf = new StringBuilder();
            try {
                URL url = new URL(urlPath);

                // Java apparently makes a connection object
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Log.d("DownloadData", "Response code " + connection.getResponseCode());

                // said object apparently provides an object for the input stream
                InputStream inStream = connection.getInputStream();
                InputStreamReader inStreamRead = new InputStreamReader(inStream);

                // Read one char at a time
                int bytesRead;
                char[] inputBuffer = new char[500];
                while (true) {
                    bytesRead = inStreamRead.read(inputBuffer);
                    if (bytesRead <= 0){
                        break;
                    }
                    // Add whatever's in the buffer to the tempBuf
                    xmlFileBuf.append(String.copyValueOf(inputBuffer, 0, bytesRead));
                }
                return xmlFileBuf.toString();
            } catch (IOException e) {
                Log.d("DownloadData", "IO Exception caught reading data" + e.getMessage());
            } catch (SecurityException e) {
                Log.d("DownloadData", "Security permission not given" + e.getMessage());
            }

            return null;
        }

    }

}
