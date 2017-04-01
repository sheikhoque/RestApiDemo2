/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cestarcollege.controller;
import com.cestarcollege.model.Pie;
import com.cestarcollege.model.PieRepository;
import com.sun.corba.se.impl.ior.ObjectReferenceFactoryImpl;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sheik.Mamun
 */
@RestController
@RequestMapping("/pies")
public class PieRestController {
    @Autowired
    private PieRepository repo;
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Collection<Pie>> getAllPies(){
        return new ResponseEntity<>((Collection<Pie>)repo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ResponseEntity<Pie> getPieWithId(@PathVariable Long id){
        return new ResponseEntity<>(repo.findOne(id), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, params={"name"})
    public ResponseEntity<Collection<Pie>> findPieWithName(@RequestParam(value="name") String name){
        return new ResponseEntity<>(repo.findByName(name), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> addPie(@RequestBody Pie input){
        return new ResponseEntity<>(repo.save(input), HttpStatus.CREATED);
    }
}

