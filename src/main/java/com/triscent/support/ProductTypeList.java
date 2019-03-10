package com.triscent.support;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeList {

    public static List<String> allProductTypesList() {

        List<String> productList = new ArrayList<>();

        for (ProductType productType : ProductType.values())
            productList.add(productType.name());

        for (ProductType.COMPUTERS computers : ProductType.COMPUTERS.values())
            productList.add(computers.name());

        for (ProductType.ELECTONICS electonics : ProductType.ELECTONICS.values())
            productList.add(electonics.name());

        return productList;
    }
}