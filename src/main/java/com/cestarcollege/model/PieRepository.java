/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cestarcollege.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sheik.Mamun
 */
public interface PieRepository extends CrudRepository<Pie, Long>{
    List<Pie> findByName(String name);
}
