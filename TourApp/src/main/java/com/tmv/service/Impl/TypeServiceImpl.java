/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.Type;
import com.tmv.repository.TypeRepository;
import com.tmv.service.TypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class TypeServiceImpl implements TypeService{
     @Autowired
     private TypeRepository typeRepository;
    
    
    @Override
    public List<Type> getTypes() {
        return this.typeRepository.getTypes();
    }

    @Override
    public Type getTypeById(int typeId) {
        return this.typeRepository.getTypeById(typeId);
    }
    
}
