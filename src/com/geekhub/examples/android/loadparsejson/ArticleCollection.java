package com.geekhub.examples.android.loadparsejson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: boss1088
 * Date: 11/12/12
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleCollection extends Vector {

    public static ArticleCollection fromJson(JSONObject data) throws JSONException {
        ArticleCollection collection = new ArticleCollection();

        JSONObject jsonFeed = data.getJSONObject("feed");
        JSONArray jsonEntry = jsonFeed.getJSONArray("entry");

        for (int i = 0; i < jsonEntry.length(); i++) {
            collection.add(new Article(jsonEntry.getJSONObject(i)));
        }

        return collection;
    }
}
