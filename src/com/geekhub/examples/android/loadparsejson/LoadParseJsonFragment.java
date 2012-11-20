package com.geekhub.examples.android.loadparsejson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: boss1088
 * Date: 11/12/12
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadParseJsonFragment extends Fragment {

    private static class Self {
        public View view;
        public boolean restore;
        public FragmentActivity activity;
        public ArticleCollection articles;
    }

    Self _self = new Self();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _self.activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO _self.view = inflate view
        return _self.view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (_self.restore && _self.articles != null && _self.articles.size() > 0) {
            updateUi();
            _self.restore = false;
        } else {
            loadData();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        _self.restore = true;
    }

    private void loadData() {
        showLoadingIndicator();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String getResponse = JsonLoader.makeGetRequest();
                    JSONObject jsonObject = new JSONObject(getResponse);

                    _self.articles = ArticleCollection.fromJson(jsonObject);

                    updateUi();
                } catch (IOException e) {
                    Toast.makeText(_self.activity, "Something goes WRONG", Toast.LENGTH_LONG);
                } catch (JSONException e) {
                    Toast.makeText(_self.activity, "Something goes WRONG", Toast.LENGTH_LONG);
                } finally {
                    hideLoadingIndicator();
                }
            }
        }).start();
    }

    private void hideLoadingIndicator() {
        _self.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO hide loading indicator
            }
        });
    }

    private void showLoadingIndicator() {
        _self.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO show loading indicator
            }
        });
    }

    private void updateUi() {
        _self.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO update UI
            }
        });
    }
}
