package com.heima.mycomponentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponentCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_SHORT).show();
                //同步调用，直接返回结果
                CCResult result = CC.obtainBuilder("ComponentA")
                        .setActionName("LoginActivity")
                        .build()
                        .call();

                //或 异步调用，不需要回调结果
                String callId1 = CC.obtainBuilder("ComponentA")
                        .setActionName("LoginActivity")
                        .build()
                        .callAsync();


                //或 异步调用，在主线程执行回调
                String callId2 = CC.obtainBuilder("ComponentA")
                        .setActionName("LoginActivity")
                        .build()
                        .callAsyncCallbackOnMainThread(new IComponentCallback() {
                            @Override
                            public void onResult(CC cc, CCResult result) {result.getDataItem("yjj");
                                //此onResult在主线程中运行
//                                String toast = "login " + (result.isSuccess() ? "success" : "failed");
                                String toast = "login " + result.getDataItem("yjj");
                                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
    }
}
