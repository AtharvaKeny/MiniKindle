package com.example.minikindle.Interface;

import com.example.minikindle.Model.Comic;

import java.util.List;

public interface IComicLoadDone {
    void onComicLoadDoneListener(List<Comic> comicList);
}
