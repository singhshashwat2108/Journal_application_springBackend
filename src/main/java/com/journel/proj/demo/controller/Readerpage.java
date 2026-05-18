package com.journel.proj.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public boolean createEntry(@RequestBody Journalentry myentry){          // requestbody is added to the db
    journalentry.put(myentry.getID(), myentry);
    return true;    
  }
  

  @GetMapping("/id/{myid}")                                   // just like this we ahve also RequestVariable
  public Journalentry getdata(@PathVariable long myid) {
      return journalentry.get(myid);
  }

  @DeleteMapping("/id/{myid}")                                   // just like this we ahve also RequestVariabl
  public Journalentry removedata(@PathVariable long myid) {
      return journalentry.remove(myid);
  }

  @PutMapping("/id/{myid}")
  public Journalentry updatedata(@PathVariable long myid, @RequestBody Journalentry myentry){
    return journalentry.put(myid, myentry);
  }
  
}
