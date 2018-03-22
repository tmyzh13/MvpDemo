package com.example.issuser.mvpdemo.mqttserver;

import android.util.Log;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by issuser on 2018/3/21.
 */

public class PushCallback implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
        //连接丢失后，可以在这里重连
        Log.e("yzh","pushCallback");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //订阅后得到的消息会执行到这里面
        Log.e("yzh","接受消息主题："+s);
        Log.e("yzh","接收到Qos:"+mqttMessage.getQos());
        Log.e("yzh","接受消息内容："+new String(mqttMessage.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        //消息分发完成状态
        Log.e("yzh","deliveryComplete--"+iMqttDeliveryToken.isComplete());
    }

}
