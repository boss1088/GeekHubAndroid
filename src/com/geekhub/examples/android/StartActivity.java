package com.geekhub.examples.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {

    private static StartActivity Instance;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Instance = this;

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, SettingsActivity.class));
            }
        });
    }

    public static class BroadcastListener extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Instance == null || intent == null) {
                return;
            }

            String action = intent.getAction();
            if (action.equals(SettingsActivity.EXTRA_SETTINGS_CHANGE)) {
                ((Button) Instance.findViewById(R.id.button_1)).setText("Settings Changed");
            }
        }
    }
}
