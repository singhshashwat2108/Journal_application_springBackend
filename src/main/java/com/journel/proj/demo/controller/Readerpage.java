package com.journel.proj.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journel.proj.demo.entity.Journalentry;



@RestController
@RequestMapping("/Journal")                     //this endpoint will encompasses the whole class 
public class Readerpage {

  private Map<Long, Journalentry> journalentry= new HashMap<>();
  
  @GetMapping("/read")                                 //  this method available at  ../journal/read 
  public List<Journalentry> getMethodName() {
      return new ArrayList<>(journalentry.values());
  }

  @PostMapping("/create-entries")
  public boolean createEntry(@RequestBody Journalentry myentry){
    journalentry.put(myentry.getID(), myentry);
    return true;    
  }
  
  
}
