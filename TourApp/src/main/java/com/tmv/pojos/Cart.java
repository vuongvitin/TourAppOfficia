/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.pojos;

/**
 *
 * @author PC
 */
public class Cart {
    private String tourName;
    private Long priceAdult;
    private int quantityAdult;
    private Long priceChildren;
    private int quantityChildren;


    /**
     * @return the tourName
     */
    public String getTourName() {
        return tourName;
    }

    /**
     * @param tourName the tourName to set
     */
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    /**
     * @return the priceAdult
     */
    public Long getPriceAdult() {
        return priceAdult;
    }

    /**
     * @param priceAdult the priceAdult to set
     */
    public void setPriceAdult(Long priceAdult) {
        this.priceAdult = priceAdult;
    }

    /**
     * @return the quantityAdult
     */
    public int getQuantityAdult() {
        return quantityAdult;
    }

    /**
     * @param quantityAdult the quantityAdult to set
     */
    public void setQuantityAdult(int quantityAdult) {
        this.quantityAdult = quantityAdult;
    }

    /**
     * @return the priceChildren
     */
    public Long getPriceChildren() {
        return priceChildren;
    }

    /**
     * @param priceChildren the priceChildren to set
     */
    public void setPriceChildren(Long priceChildren) {
        this.priceChildren = priceChildren;
    }

    /**
     * @return the quantityChildren
     */
    public int getQuantityChildren() {
        return quantityChildren;
    }

    /**
     * @param quantityChildren the quantityChildren to set
     */
    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    

}