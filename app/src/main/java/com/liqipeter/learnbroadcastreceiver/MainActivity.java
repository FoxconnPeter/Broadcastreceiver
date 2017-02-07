package com.liqipeter.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnSendMSG).setOnClickListener(this);
        findViewById(R.id.btnSendReg).setOnClickListener(this);
        findViewById(R.id.btnSendUnReg).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSendMSG:
              //  Intent i = new Intent(this,MyReceiver.class);
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("data","广播信息");
               // sendBroadcast(i);
                sendOrderedBroadcast(i,null);
                break;
            case R.id.btnSendReg:
                if (receiver==null){
                    receiver = new MyReceiver();
                    registerReceiver(receiver,new IntentFilter(MyReceiver.ACTION));

                }

                break;
            case R.id.btnSendUnReg:
                if (receiver!=null){
                    unregisterReceiver(receiver);
                    receiver=null;

                }

                break;

        }

    }
    private MyReceiver receiver = null;

}

