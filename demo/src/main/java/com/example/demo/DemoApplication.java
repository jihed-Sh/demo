package com.example.demo;

import com.example.demo.dal.entity.*;
import com.example.demo.dal.repo.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(InvoiceRepository repository) {
        List<Tax> taxes = new ArrayList<>();
        Tax tax = new Tax();
        tax.setTaxName("Tva");
        tax.setTaxPrice(1245);
        taxes.add(tax);
        List<ItemInfo> itemInfoList = new ArrayList<>();
        ItemInfo itemInfo = new ItemInfo();
        Item item = new Item();
        item.setName("PlayStation");
        itemInfo.setItem(item);
        itemInfo.setQuantity(2);
        itemInfo.setPrice(500);
        itemInfoList.add(itemInfo);

        return args -> {
            Invoice invoice = new Invoice("12345",
                    false,
                    false,
                    new AppIdentity(),
                    new AppIdentity(),
                    taxes,
                    0,
                    4,
                    "customer@gmail.com",
                    "customer@gmail.com",
                    "$",
                    itemInfoList,
                    new PriceRule()
            );
            Invoice invoice1 = new Invoice("54321",
                    false,
                    false,
                    new AppIdentity(),
                    new AppIdentity(),
                    taxes,
                    45,
                    2,
                    "customer1@gmail.com",
                    "supplier@gmail.com",
                    "€",
                    itemInfoList,
                    new PriceRule()
            );
            List<Invoice> invoices = new ArrayList<Invoice>();
            invoices.add(invoice1);
            invoices.add(invoice);
            repository.insert(invoices);
        };
    }

}
