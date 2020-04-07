package com.heima.mycomponentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponentCallback;
import com.billy.cc.core.component.remote.RemoteCC;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_SHORT).show();
                //同步调用，直接返回结果
                Map<String, Object> params = new HashMap<>();
                params.put("name","杨均劲");
                params.put("age","29");
                params.put("length","172cm");
//                CCResult result = CC.obtainBuilder("ComponentA")
//                        .addParams(params)
//                        .setActionName("LoginActivity")
//                        .build()
//                        .call();

//                //或 异步调用，不需要回调结果
//                String callId1 = CC.obtainBuilder("ComponentA")
//                        .setActionName("LoginActivity")
//                        .build()
//                        .callAsync();
//
//
                //或 异步调用，在主线程执行回调
                String callId2 = CC.obtainBuilder("ComponentA")
                        .setActionName("LoginActivity")
                        .addParams(params)
                        .build()
                        .callAsyncCallbackOnMainThread(new IComponentCallback() {
                            @Override
                            public void onResult(CC cc, CCResult result) {
                                //此onResult在主线程中运行
//                                String toast = "login " + (result.isSuccess() ? "success" : "failed");
//                                String toast = "login " + result.getDataItem("success","默认数据");
//                                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
                            }
                        });

//                String callId3 = CC.obtainBuilder("ComponentA")
//                        .setActionName("LoginActivity")
//                        .addParams(params)
//                        .build()
//                        .callAsync(new IComponentCallback() {
//                            @Override
//                            public void onResult(CC cc, final CCResult result) {
//                                //此onResult在主线程中运行
////                                String toast = "login " + (result.isSuccess() ? "success" : "failed");
//                                MainActivity.this.runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        String toast = "login " + result.getDataItem("success","默认数据");
//                                        Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            }
//                        });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
