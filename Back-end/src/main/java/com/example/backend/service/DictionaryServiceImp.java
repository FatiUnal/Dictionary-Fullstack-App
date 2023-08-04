package com.example.backend.service;

import com.example.backend.dto.DictionaryRequestDto;
import com.example.backend.entity.Dictionary;
import com.example.backend.exception.DictionaryNotDelete;
import com.example.backend.exception.DictionaryNotFound;
import com.example.backend.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictionaryServiceImp implements DictionaryService{
    private DictionaryRepository dictonaryRepo;

    public DictionaryServiceImp(DictionaryRepository dictionaryRepository){
        this.dictonaryRepo = dictionaryRepository;
    }

    @Override
    public List<Dictionary> getAll() {
        return dictonaryRepo.findAll();
    }

    @Override
    public Dictionary create(DictionaryRequestDto dictionaryRequestDto) {
        Dictionary dictionary = new Dictionary(dictionaryRequestDto.getEnglishText(),
                                               dictionaryRequestDto.getTurkishText(),
                                               dictionaryRequestDto.getDescription());

        return dictonaryRepo.save(dictionary);
    }

    @Override
    public Dictionary update(int id, DictionaryRequestDto dictionaryRequestDto) {
        dictonaryRepo.findById(id).orElseThrow(()->new DictionaryNotFound(id));
        Dictionary newDictionary = new Dictionary(id,dictionaryRequestDto.getEnglishText(),
                                                     dictionaryRequestDto.getTurkishText(),
                                                     dictionaryRequestDto.getDescription());
        return dictonaryRepo.save(newDictionary);
    }

    @Override
    public String delete(int id) {
        Dictionary dictionary = dictonaryRepo.findById(id).orElseThrow(()->new DictionaryNotFound(id));
        dictonaryRepo.deleteById(dictionary.getId());
        if (dictonaryRepo.existsById(id))
            throw new DictionaryNotDelete(id);

        return "deleted";
    }

    @Override
    public List<Dictionary> getSearchList(String x) {
        List<Dictionary> dictionaryList = dictonaryRepo.findAllByEnglishTextStartingWithOrTurkishTextStartingWith(x);
        for (int i = 0;i<dictionaryList.size();i++){
            System.out.println(dictionaryList.get(i));
        }
        return dictionaryList;
    }
}
