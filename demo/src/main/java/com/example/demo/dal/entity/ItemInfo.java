package com.example.demo.dal.entity;

import lombok.Data;

import java.util.List;
@Data
public class ItemInfo {
    private double quantity;
    private PriceRule priceRule;
    private double price;
    private List<Tax> taxList;
    private Item item;

}
