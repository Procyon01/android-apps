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
        Application currentRecord = null;      // to add data from currently processing application entry
        boolean inEntry = false;        // checker for inside/outside an application entry
        String textValue = "";          // XML field data

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
                        if (tagName.equalsIgnoreCase("entry")){
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (inEntry){
                            if (tagName.equalsIgnoreCase("entry")) {
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("name")) {
                                currentRecord.setName(textValue);
                            } else if (tagName.equalsIgnoreCase("artist")){
                                currentRecord.setArtist(textValue);
                            } else if (tagName.equalsIgnoreCase("releaseDate")){
                                currentRecord.setReleaseDate(textValue);
                            }
                        }
                        break;

                    default:
                        // noop
                }
                eventType = xpp.next();
            }

        } catch (Exception e){
            success = false;
            e.printStackTrace();
        }

        // Give us a little confirmation this worked
        int count = 1;
        for (Application app : applications){
            Log.d("ParseApplications", "#" + count + " Name: " + app.getName());
            Log.d("ParseApplications", "Artist: " + app.getArtist());
            Log.d("ParseApplications", "Release Date: " + app.getReleaseDate());
            count++;
        }

        return true;
    }
}
