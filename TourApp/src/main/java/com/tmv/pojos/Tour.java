/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findByName", query = "SELECT t FROM Tour t WHERE t.name = :name"),
    @NamedQuery(name = "Tour.findByThoiGian", query = "SELECT t FROM Tour t WHERE t.thoiGian = :thoiGian"),
    @NamedQuery(name = "Tour.findByNgayKhoiHanh", query = "SELECT t FROM Tour t WHERE t.ngayKhoiHanh = :ngayKhoiHanh"),
    @NamedQuery(name = "Tour.findByDiemDen", query = "SELECT t FROM Tour t WHERE t.diemDen = :diemDen"),
    @NamedQuery(name = "Tour.findByPhuongTien", query = "SELECT t FROM Tour t WHERE t.phuongTien = :phuongTien"),
    @NamedQuery(name = "Tour.findByImage", query = "SELECT t FROM Tour t WHERE t.image = :image"),
    @NamedQuery(name = "Tour.findByMota", query = "SELECT t FROM Tour t WHERE t.mota = :mota"),
    @NamedQuery(name = "Tour.findByGiaTour", query = "SELECT t FROM Tour t WHERE t.giaTour = :giaTour"),

    @NamedQuery(name = "Tour.findByDiemKhoiHanh", query = "SELECT t FROM Tour t WHERE t.diemKhoiHanh = :diemKhoiHanh")})
public class Tour implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_tour")
    private Long giaTour;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tour", fetch = FetchType.EAGER)
////    @LazyCollection(LazyCollectionOption.FALSE)
//    @JsonIgnore
//    private Collection<Imges> imgesCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 150, message = "{product.name.lengErr}")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "thoi_gian")
    private String thoiGian;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "ngay_khoi_hanh")
    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date ngayKhoiHanh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "diem_den")
    private String diemDen;
    @Size(max = 50)
    @Column(name = "phuong_tien")
    private String phuongTien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 110)
    @Column(name = "image")
    private String image;
    @Size(max = 1000)
    @Column(name = "Mo_ta")
    private String mota;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "diem_khoi_hanh")
    private String diemKhoiHanh;
    
    @JoinColumn(name = "type_id")
    @ManyToOne
    private Type typeId;
    
    @Transient
    @JsonIgnore
    private MultipartFile file;
    


    public Tour() {
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Tour(Integer id, String name, String thoiGian, Date ngayKhoiHanh, String diemDen, String image, Long giaTour, String diemKhoiHanh) {
        this.id = id;
        this.name = name;
        this.thoiGian = thoiGian;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.diemDen = diemDen;
        this.image = image;
        this.giaTour = giaTour;
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Tour)) {
//            return false;
//        }
//        Tour other = (Tour) object;
////        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
////            return false;
////        }
//        return true;
//    }

    @Override
    public String toString() {
        return "com.tmv.pojos.Tour[ id=" + id + " ]";
    }

//    @XmlTransient
//    public Collection<Imges> getImgesCollection() {
//        return imgesCollection;
//    }
//
//    public void setImgesCollection(Collection<Imges> imgesCollection) {
//        this.imgesCollection = imgesCollection;
//    }



    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the giaTour
     */
    public Long getGiaTour() {
        return giaTour;
    }

    /**
     * @param giaTour the giaTour to set
     */
    public void setGiaTour(Long giaTour) {
        this.giaTour = giaTour;
    }

    
}
