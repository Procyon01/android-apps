package point.flickrbrowser;

/**
 * Created by point on 2/4/2016.
 */

enum DownloadStatus {IDLE, PROCESSING, NOT_INITNALIZED, FAILED_OR_EMPTY, OK}

public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String mRawUrl;
    private String mData;

    public GetRawData(String mRawData) {
        this.mRawUrl = mRawData;
    }
}
