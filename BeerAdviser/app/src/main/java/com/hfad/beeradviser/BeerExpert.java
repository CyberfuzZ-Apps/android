package com.hfad.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("Янтарное")) {
            brands.add("O'Hara's Amber Adventure");
            brands.add("Jack Amber");
        } else {
            brands.add("Jail Pail Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }

}
