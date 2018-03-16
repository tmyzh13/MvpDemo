package com.example.issuser.mvpdemo.daggertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.daggertest.DaggerMainComponent;

import javax.inject.Inject;

import dagger.Binds;

/**
 * Created by issuser on 2018/3/15.
 */

public class DaggerTestActivity extends Activity{



    @Inject //标明需要注入的对象
    Person person;

    TextView tv_send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        //构建桥梁
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        //注入
        //注入之后会查找当前类中（@Inject）对象
        //再根据成员变量类型从module中查找哪个有@Provides注解的方法返回值为当前类型。
        component.inject(this);
        Log.e("yzh","person: "+person.toString());

//        03-16 10:26:24.226 19653-19653/com.example.issuser.mvpdemo E/yzh: person create!!!
//        03-16 10:26:24.226 19653-19653/com.example.issuser.mvpdemo E/yzh: person: com.example.issuser.mvpdemo.daggertest.Person@7648445
//        03-16 10:34:12.887 20345-20345/com.example.issuser.mvpdemo E/yzh: person create!!!
//        03-16 10:34:12.887 20345-20345/com.example.issuser.mvpdemo E/yzh: person: com.example.issuser.mvpdemo.daggertest.Person@7648445

        tv_send=(TextView)findViewById(R.id.tv_send);
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DaggerTestActivity.this,DaggerTest2Activity.class);
                startActivity(intent);
            }
        });
//        03-16 11:19:09.145 27342-27342/com.example.issuser.mvpdemo E/yzh: person create!!!
//                03-16 11:19:09.145 27342-27342/com.example.issuser.mvpdemo E/yzh: person: com.example.issuser.mvpdemo.daggertest.Person@7648445
//        03-16 11:19:16.323 27342-27342/com.example.issuser.mvpdemo E/yzh: person create!!!
//                03-16 11:19:16.323 27342-27342/com.example.issuser.mvpdemo E/yzh: Person com.example.issuser.mvpdemo.daggertest.Person@6110b4a---Person2 com.example.issuser.mvpdemo.daggertest.Person@6110b4a

    }
}
