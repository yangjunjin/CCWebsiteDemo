package com.heima.login;

import android.util.Log;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;

/**
 * author : yangjunjin
 * date : 2020/3/31 0:02
 */
public class ComponentA implements IComponent {

    @Override
    public String getName() {
        //指定组件的名称
        return "ComponentA";
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            case "LoginActivity": //响应actionName为"showActivity"的组件调用
                Log.e("ComponentA==", "我过来了");
                //跳转到页面：ActivityA
                CCUtil.navigateTo(cc, LoginActivity.class);
                //返回处理结果给调用方
                CCResult result = CCResult.success("success", "成功的数据").addData("addData", "另外的数据");
                CC.sendCCResult(cc.getCallId(), result);
                //同步方式实现（在return之前听过CC.sendCCResult()返回组件调用结果），return false
                return false;
            default:
                //其它actionName当前组件暂时不能响应，可以通过如下方式返回状态码为-12的CCResult给调用方
                CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
                return false;
        }
    }
}