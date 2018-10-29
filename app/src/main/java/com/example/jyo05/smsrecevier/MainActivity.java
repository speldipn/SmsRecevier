package com.example.jyo05.smsrecevier;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_PERM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String perms[] = {Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS};
            if(checkSelfPermission(perms[0]) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(perms[1]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(perms, REQ_PERM);
            } else {
                // already agreed
                init();
            }
        } else {
            // Under Marshmallow
            init();
        }

    }

    private void init() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQ_PERM) {
            for (int i = 0; i < grantResults.length; ++i) {
                if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한이 없으면 앱을 실행할 수 업습니다", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            init();
        }
    }
}
