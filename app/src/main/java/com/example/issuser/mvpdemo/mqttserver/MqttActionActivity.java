package com.example.issuser.mvpdemo.mqttserver;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issuser.mvpdemo.R;

/**
 * Created by issuser on 2018/3/21.
 */

public class MqttActionActivity extends Activity {

    EditText et_msg;
    TextView tv_create;
    TextView tv_send;

    ServerMQTT mServerMQTT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_action);

        et_msg=(EditText)findViewById(R.id.et_msg);
        tv_create=findViewById(R.id.tv_create);
        tv_send=findViewById(R.id.tv_send);

        tv_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mServerMQTT = new ServerMQTT() ;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mServerMQTT.sendMessage(et_msg.getText().toString());
            }
        });
    }
}
