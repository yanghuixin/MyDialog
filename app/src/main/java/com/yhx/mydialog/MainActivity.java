package com.yhx.mydialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.yhx.mydialog.dialog.ListDialog;
import com.yhx.mydialog.utils.ToastUtils;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        showListDialog();
    }

    private void showListDialog(){
        ListDialog listDialog = new ListDialog(getApplication(), new String[]{"开发票", "付款码", "看电影", "骑单车"}, new ListDialog.OnListDialogListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ToastUtils.showToast(getApplication(), "用户点击了开发票");
                        break;
                    case 1:
                        ToastUtils.showToast(getApplication(), "用户点击了付款码");
                        break;
                    case 2:
                        ToastUtils.showToast(getApplication(), "用户点击了看电影");
                        break;
                    case 3:
                        ToastUtils.showToast(getApplication(), "用户点击了骑单车");
                        break;
                }
            }
        });
        Window dialogWindow = listDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.RIGHT | Gravity.TOP);
        lp.x = 20; // 新位置X坐标
        lp.y = 20; // 新位置Y坐标
        lp.width = 300; // 宽度
        lp.height = 300; // 高度
        dialogWindow.setAttributes(lp);
        listDialog.show();
    }
}
