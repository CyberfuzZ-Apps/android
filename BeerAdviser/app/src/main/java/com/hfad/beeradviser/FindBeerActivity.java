package com.hfad.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class FindBeerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    //Вызывается когда пользователь кликает на кнопку
    public void onClickFindBeer (View view) {

        //Получить ссылку на TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        //Получить ссылку на Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //Получить вариант выбранный в Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Вывести выбранный вариант
        brands.setText(beerType);

    }
}