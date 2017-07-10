package com.commontime.cordova.restartfix;

import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class RestartFix extends CordovaPlugin {

    private static final String TAG = "RestartFix";

    public RestartFix() {
    }

    @Override
    public void onNewIntent(Intent intent) {
        if( !cordova.getActivity().isTaskRoot() ) {
            Log.i(TAG, "Is not Task Root");
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
                Log.i(TAG, "Starting from Launcher, Action-Main");
                cordova.getActivity().finish();
                return;
            }
        }
    }

    @Override
    public void onDestroy() {
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {        
        return false;
    }
}

