package com.challengesix.challenge.six.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

    private int order_id;
    private Date order_date;

}
