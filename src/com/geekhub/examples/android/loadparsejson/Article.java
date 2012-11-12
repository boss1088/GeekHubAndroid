package com.geekhub.examples.android.loadparsejson;

import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: boss1088
 * Date: 11/12/12
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Article {

    private String title;
    private String description;

    public Article() {}

    public Article(JSONObject data) {
        setTitle(data.optJSONObject("title").optString("$t"));
        setDescription(data.optJSONObject("content").optString("$t"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
