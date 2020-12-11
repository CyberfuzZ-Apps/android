package com.hfad.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        switch (color) {
            case "Светлое":
                brands.add("Bud Light");
                brands.add("Stella Artois");
                brands.add("Жигули Export");
                break;
            case "Темное":
                brands.add("Козел Темное");
                brands.add("Жатецкий Гусь Темное");
                break;
            case "Коричневое":
                brands.add("Не знаю таких))");
                break;
            case "Янтарное":
                brands.add("Волга Янтарное");
                brands.add("Эль Янтарный");
                break;
        }


        return brands;
    }

}
