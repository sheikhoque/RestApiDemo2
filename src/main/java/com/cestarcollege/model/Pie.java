/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cestarcollege.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sheik.Mamun
 */
@Entity
public class Pie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    
    public Pie(String name, String description){
        this.name= name;
        this.description = description;
    }
    
    public Pie(){}
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
}
