package com.example.backend.service;

import com.example.backend.dto.DictionaryRequestDto;
import com.example.backend.entity.Dictionary;

import java.util.List;

public interface DictionaryService {


    List<Dictionary> getAll();

    Dictionary create(DictionaryRequestDto dictionaryRequestDto);

    Dictionary update(int id, DictionaryRequestDto dictionaryRequestDto);

    String delete(int id);

    List<Dictionary> getSearchList(String x);
}
