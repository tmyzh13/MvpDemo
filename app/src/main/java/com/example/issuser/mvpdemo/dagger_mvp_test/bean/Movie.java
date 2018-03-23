package com.example.issuser.mvpdemo.dagger_mvp_test.bean;

import java.util.List;

/**
 * Created by issuser on 2018/3/23.
 */

public class Movie {
    private String title;
    private List<Subjects> subjects;


    public String getTitle() {
        return title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }
}
