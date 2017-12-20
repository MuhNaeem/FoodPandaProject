package com.example.android.foodpanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        Button toStart = (Button) findViewById(R.id.back_start);
        toStart.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent goStart = new Intent(MenuList.this, MainActivity.class);
                                              startActivity(goStart);
                                          }
                                      }

        );

        Button toBurger = (Button) findViewById(R.id.burger_menu);
        toBurger.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent goBurger = new Intent(MenuList.this, BurgerMenu.class);
                                           startActivity(goBurger);
                                       }
                                   }

        );

        Button toSweet = (Button) findViewById(R.id.sweet_menu);
        toSweet.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent goSweet = new Intent(MenuList.this, SweetMenu.class);
                                            startActivity(goSweet);
                                        }
                                    }

        );
    }
}
