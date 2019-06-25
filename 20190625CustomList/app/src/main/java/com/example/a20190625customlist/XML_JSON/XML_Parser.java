package com.example.a20190625customlist.XML_JSON;

import android.content.Context;

import com.example.a20190625customlist.Flower;
import com.example.a20190625customlist.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XML_Parser {
    private Context context;
    private Flower currentFlower;
    private ArrayList<Flower> flowerArrayList = new ArrayList<>();
    private String currentTag;

    private InputStream inputStream;
    String stringInputStream;

    private InputStreamReader inputStreamReader;
    String stringInputStreamReader;

    public XML_Parser(Context context) {
        this.context = context;
    }

    public void xmlInputStream() {
        // read xml file by inputStream
        inputStream = context.getResources().openRawResource(R.raw.flowers_xml);
        // stringInputStream = convert
    }

    public void xmlInputStreamReader() {

    }

    public ArrayList<Flower> parseXML() {
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            //xmlParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

            // Read 'R.raw.flowers_xml' and set the result for 'inputStream' variable
            xmlInputStream();

            // pass inputStream to XmlPullParser
            xmlPullParser.setInput(inputStream, null);

            // XmlPullParser:
            // 0:START_TAG
            // 1:END_TAG

            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xmlPullParser.getEventType()) {
                    case XmlPullParser.START_TAG:
                        handleStartTag(xmlPullParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        handleText(xmlPullParser.getText());
                        break;
                    case XmlPullParser.END_TAG:
                        currentTag = null;
                        break;
                }
                xmlPullParser.next();
            }
            inputStream.close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return flowerArrayList;
    }

    private void handleText(String text) {
        if (currentTag == null || currentFlower == null) return;

        switch (currentTag) {
            case "productId":
                currentFlower.setProductId(Long.valueOf(text));
                break;
            case "category":
                currentFlower.setCategory(text);
                break;
            case "name":
                currentFlower.setName(text);
                break;
            case "instructions":
                currentFlower.setInstructions(text);
                break;
            case "price":
                currentFlower.setPrice(Double.valueOf(text));
                break;
            case "photo":
                currentFlower.setPhoto(text);
                System.out.println("--- XML Object: " + currentFlower.toString());
                break;
            default:
                break;

        }
    }

    private void handleStartTag(String tagname) {
        if ("product".equals(tagname)) {
            currentFlower = new Flower();
            flowerArrayList.add(currentFlower);
        } else {
            currentTag = tagname;
        }
    }
}
