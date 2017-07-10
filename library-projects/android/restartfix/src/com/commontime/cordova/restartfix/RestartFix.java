package com.commontime.cordova.restartfix;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class RestartFix extends CordovaPlugin {

    private static final String TAG = "RestartFix";

    public RestartFix() {
    }

    @Override
    protected void pluginInitialize() {
        if( !cordova.getActivity().isTaskRoot() ) {
            final Intent intent = cordova.getActivity().getIntent();
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
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
