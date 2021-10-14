/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.formatter;

import com.tmv.pojos.Type;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class TypeFormatter implements Formatter<Type>{

    @Override
    public String print(Type type, Locale locale) {
        return String.valueOf(type.getId());
    }

    @Override
    public Type parse(String typeId, Locale locale) throws ParseException {
        Type t = new Type();
        t.setId(Integer.parseInt(typeId));
        return t;
    }
    
}
