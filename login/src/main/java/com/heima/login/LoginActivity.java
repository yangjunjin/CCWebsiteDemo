package com.heima.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;

public class LoginActivity extends Activity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text = findViewById(R.id.text);

        //传递过来的值
        String name = CCUtil.getNavigateParam(LoginActivity.this, "name", "");
        String age = CCUtil.getNavigateParam(LoginActivity.this, "age", "");
        String length = CCUtil.getNavigateParam(LoginActivity.this, "length", "");
        text.setText(name + "\n" + age + "\n" + length);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CC.sendCCResult(CCUtil.getNavigateCallId(LoginActivity.this), CCResult.success("success", "成功的数据").addData("addData", "另外的数据"));
    }
}
