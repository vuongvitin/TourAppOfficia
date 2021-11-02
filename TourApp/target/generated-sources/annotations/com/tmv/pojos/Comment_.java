package com.tmv.pojos;

import com.tmv.pojos.Tour;
import com.tmv.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-31T21:58:43")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> createdDate;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> avatar;
    public static volatile SingularAttribute<Comment, User> user;
    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, Tour> tour;

}