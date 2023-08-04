package com.example.backend.entity;

import com.example.backend.repository.DictionaryRepository;

import java.util.ArrayList;
import java.util.List;

public class dsadsa {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary(1,"dfsa","dfdaaasdsa","dafdsa");
        Dictionary dictionary1 = new Dictionary(2,"dfsadfdggg","dsa","dafdsa");
        Dictionary dictionary2 = new Dictionary(3,"ddsadfsa","dgghjjaasdsa","dafds");
        List<Dictionary> dictionaryList = new ArrayList<>();
        dictionaryList.add(dictionary);
        dictionaryList.add(dictionary1);
        dictionaryList.add(dictionary2);

        for (int i = 0;i< dictionaryList.size();i++){
            System.out.println(dictionaryList.get(i));
        }

    }
}
