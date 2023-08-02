package com.example.backend.controller;

import com.example.backend.dto.DictionaryRequestDto;
import com.example.backend.dto.DictionaryResponseDto;
import com.example.backend.entity.Dictionary;
import com.example.backend.service.DictionaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    private DictionaryService dictionaryService;
    public DictionaryController(DictionaryService dictionaryService){
        this.dictionaryService = dictionaryService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Dictionary> list = dictionaryService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DictionaryRequestDto dictionaryRequestDto){
        Optional<Dictionary> dictionary =Optional.ofNullable(dictionaryService.create(dictionaryRequestDto));

        if (dictionary.isPresent())
            return new ResponseEntity<>(null,HttpStatus.CREATED);
        else
            return new ResponseEntity<>(dictionary,HttpStatus.BAD_REQUEST);


    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id , @RequestBody DictionaryRequestDto dictionaryRequestDto){
        Optional<Dictionary> dictionary = Optional.ofNullable(dictionaryService.update(id,dictionaryRequestDto));
        if (dictionary.isPresent())
            return new ResponseEntity<>(dictionary,HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(dictionary,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        String dictionary = dictionaryService.delete(id);
        return new ResponseEntity<>(dictionary,HttpStatus.NO_CONTENT);
    }




}
