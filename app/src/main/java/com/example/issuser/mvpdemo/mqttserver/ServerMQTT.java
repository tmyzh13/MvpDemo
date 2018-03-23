package com.example.issuser.mvpdemo.mqttserver;


import android.util.Log;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by issuser on 2018/3/21.
 */

public class ServerMQTT {

    public static final String HOST="tcp://169.254.232.176:61681";
    //定义一个主题
    public static final String TOPIC="topic11";
    private static final String clientid="client1";

    private MqttClient client;
    private MqttTopic topic11;
    private String userName="admin";
    private String passWord="password";

    private MqttMessage message;
    private ServerMQTT mServer;

    public ServerMQTT(){
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        try {
            client =new MqttClient(HOST,clientid,new MemoryPersistence());
            connect();
        }catch (Exception e){
            Log.e("yzh","SERVERMQTT--"+e.toString());
        }

    }

    private void connect(){
        MqttConnectOptions options =new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        //设置超时时间
        options.setConnectionTimeout(10);
        //设置会话心跳时间
        options.setKeepAliveInterval(20);
        try{
            client.setCallback(new PushCallback());
            client.connect(options);
            topic11=client.getTopic(TOPIC);
        }catch (Exception e){
            Log.e("yzh","connect--"+e.toString());
        }
    }

//    IMqttActionListener listener =new IMqttActionListener() {
//        @Override
//        public void onSuccess(IMqttToken iMqttToken) {
//
//        }
//
//        @Override
//        public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
//
//        }
//    }

    public void publish(MqttTopic topic,MqttMessage message)
            {
                try{
                    MqttDeliveryToken token =topic.publish(message);
                    token.waitForCompletion();
                    Log.e("yzh","message is published completely!"+token.isComplete());
                }catch (Exception e){
                    Log.e("yzh","publish--"+e.toString());
                }

    }

    public void sendMessage(String msg){
        try{
            message =new MqttMessage();
            message.setQos(1);
            message.setRetained(true);
            message.setPayload(msg.getBytes());
            publish(topic11,message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
