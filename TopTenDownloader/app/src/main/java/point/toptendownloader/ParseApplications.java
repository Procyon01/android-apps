package point.toptendownloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by point on 2/3/2016.
 */
public class ParseApplications {

    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<Application>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }
    
    public boolean process(){

        boolean success;
        Application currentRecord;      // to add data from currently processing application entry
        boolean inEntry = false;        // checker for inside/outside an application entry
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            // Loop until end doc, neat they implemented this
            while (eventType != XmlPullParser.END_DOCUMENT){
                // tagName corresponds to XML tag field
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        Log.d("ParseApplications", "Starting tag for " + tagName);
                        if (tagName.equalsIgnoreCase("entry")){
                            inEntry = true;
                            currentRecord = new Application();
                            break;
                        }
                    case XmlPullParser.END_TAG:
                        Log.d("ParseApplications", "Ending tag for " + tagName);
                    default:
                        // Nope
                }
                eventType = xpp.next();
            }

        } catch (Exception e){
            success = false;
            e.printStackTrace();
        }
        return true;
    }
}
