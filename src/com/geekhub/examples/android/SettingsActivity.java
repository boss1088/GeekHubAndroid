package com.geekhub.examples.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: boss1088
 * Date: 11/20/12
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettingsActivity extends Activity {

    final public static String EXTRA_SETTINGS_CHANGE = "com.geekhub.examples.android.ACTION_SETTING_CHANGED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SettingsActivity.this.finish();
                sendBroadcast(new Intent(EXTRA_SETTINGS_CHANGE));
            }
        });
    }
}
