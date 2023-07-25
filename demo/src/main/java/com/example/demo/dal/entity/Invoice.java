package com.example.demo.dal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document
public class Invoice {
    @Id
    private String id;
    private String invoiceNumber;
    private boolean priceAware;
    private boolean quantityAware;
    private AppIdentity supplier;
    private AppIdentity customer;
    private List<Tax> taxes;
    private double priceTaxFree;
    private double priceVatFree;
    private String customerAddress;
    private String supplierAddress;
    private String currency;
    private List<ItemInfo> itemList;
    private PriceRule priceRule;

    public Invoice(String invoiceNumber, boolean priceAware, boolean quantityAware, AppIdentity supplier, AppIdentity customer, List<Tax> taxes, double priceTaxFree, double priceVatFree, String customerAddress, String supplierAddress, String currency, List<ItemInfo> itemList, PriceRule priceRule) {
        this.invoiceNumber = invoiceNumber;
        this.priceAware = priceAware;
        this.quantityAware = quantityAware;
        this.supplier = supplier;
        this.customer = customer;
        this.taxes = taxes;
        this.priceTaxFree = priceTaxFree;
        this.priceVatFree = priceVatFree;
        this.customerAddress = customerAddress;
        this.supplierAddress = supplierAddress;
        this.currency = currency;
        this.itemList = itemList;
        this.priceRule = priceRule;
    }
}
