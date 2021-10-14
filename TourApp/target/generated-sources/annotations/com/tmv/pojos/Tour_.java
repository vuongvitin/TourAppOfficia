package com.tmv.pojos;

import com.tmv.pojos.Comment;
import com.tmv.pojos.Imges;
import com.tmv.pojos.Type;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-14T07:43:23")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, String> image;
    public static volatile SingularAttribute<Tour, Date> ngayKhoiHanh;
    public static volatile CollectionAttribute<Tour, Comment> commentCollection;
    public static volatile CollectionAttribute<Tour, Imges> imgesCollection;
    public static volatile SingularAttribute<Tour, String> diemKhoiHanh;
    public static volatile SingularAttribute<Tour, String> name;
    public static volatile SingularAttribute<Tour, Long> giaTour;
    public static volatile SingularAttribute<Tour, Type> typeId;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, String> mota;
    public static volatile SingularAttribute<Tour, String> diemDen;
    public static volatile SingularAttribute<Tour, String> phuongTien;
    public static volatile SingularAttribute<Tour, String> thoiGian;

}