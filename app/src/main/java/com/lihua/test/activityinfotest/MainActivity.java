package com.lihua.test.activityinfotest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityInfo ai = null;
        PackageManager pm = MainActivity.this.getPackageManager();
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(resolveIntent,0);

        for (ResolveInfo resolveInfo:resolveInfoList) {
            if (resolveInfo.activityInfo.packageName.equals("com.lihua.test.activityinfotest")) {
                Log.d("wanlihua", "wanlihua debug resolveInfo activityInfo.packageName:" + resolveInfo.activityInfo.packageName + ", " + resolveInfo.activityInfo.name);
                ai = resolveInfo.activityInfo;
                //Toast.makeText(this, resolveInfo.activityInfo.name, Toast.LENGTH_SHORT).show();
                break;
            }
        }

    }
}
