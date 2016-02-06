package point.flickrbrowser;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

/**
 * Created by point on 2/4/2016.
 */

enum DownloadStatus {IDLE, PROCESSING, NOT_INITNALIZED, FAILED_OR_EMPTY, OK}

public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String mRawUrl;
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRawData(String mRawData) {
        this.mRawUrl = mRawData;
    }
    
    public void reset() {
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mRawUrl = null;
        this.mData = null;
    }

    public DownloadStatus getDownloadStatus() {
        return mDownloadStatus;
    }

    public String getmData() {
        return mData;
    }
    
    public class DownloadRawData extends AsyncTask<String, Void, String> {
        
        protected void onPostExecute(String webData){
            
        }
        
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            
            if (params == null){
                return null;
            }
            
            
        }
    }
    
}
