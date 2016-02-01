package point.toptendownloader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadData dlData = new DownloadData();
        dlData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");
    }

    public class DownloadData extends AsyncTask<String, Void, String>{
        // Second param of AsyncTask is typically progress bar. Leaving for now

        private String fileContents;

        @Override
        protected String doInBackground(String... params) {
            // "String... params": new in java, represents variable number of params in array

            fileContents = downloadXML(params[0]);
            if (fileContents = null){
                Log.d("DownloadData", "Error downloading item");
                Toast.makeText("Error downloading item", Toast.LENGTH_LONG);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("DownloadData", "Result: " + s);
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

                // Read one char at a time
                int bytesRead;
                char[] inputBuffer = new char[500];
                while (true) {     // Negative
                    bytesRead = inStream.read(inputBuffer);
                    if (bytesRead <= 0){
                        break;
                    }
                    // Add whatever's in the buffer to the tempBuf
                    xmlFileBuf.append(String.copyValueOf(inputBuffer, 0, bytesRead));
                }
                return xmlFileBuf.toString();
            } catch (IOException e) {
                Log.d("DownloadData", "IO Exception caught reading data" + e.getMessage());

            }

        }

    }

}
