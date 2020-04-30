/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.repository;

import com.test.mytest.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author augustobatz
 */
public interface EventRespository extends JpaRepository<Event, Integer> {
}
