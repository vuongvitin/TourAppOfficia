/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tmv.pojos.Staff;
import com.tmv.repository.StaffRepository;
import com.tmv.service.StaffService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Staff> getStaffs(String kw, int page) {
        return this.staffRepository.getStaffs(kw, page);
    }

    @Override
    public Staff getStaffById(int staffId) {
        return this.staffRepository.getStaffById(staffId);
    }

    @Override
    public boolean addOrUpdateTour(Staff staff) {
         try {
             Map r = this.cloudinary.uploader().upload(staff.getFile().getBytes(),
                     ObjectUtils.asMap("resource_type", "auto"));
            
            staff.setAvatar((String) r.get("secure_url"));
            
            
            return this.staffRepository.addOrUpdateTour(staff);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStaff(int staffId) {
        return this.staffRepository.deleteStaff(staffId);
    }
}
