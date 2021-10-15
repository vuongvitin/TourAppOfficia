/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service;

import com.tmv.pojos.Staff;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StaffService {
    List<Staff> getStaffs(String kw, int page);
    Staff getStaffById(int staffId);
    boolean addOrUpdateTour(Staff staff);
    boolean deleteStaff(int staffId);
}
