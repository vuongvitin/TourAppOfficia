package com.tmv.pojos;

import com.tmv.pojos.SaleOrder;
import com.tmv.pojos.Tour;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-31T21:58:43")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Long> unitPrice;
    public static volatile SingularAttribute<OrderDetail, Tour> tourId;
    public static volatile SingularAttribute<OrderDetail, Integer> num;
    public static volatile SingularAttribute<OrderDetail, Integer> id;
    public static volatile SingularAttribute<OrderDetail, SaleOrder> saleOrder;

}