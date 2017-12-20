package com.example.android.foodpanda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BurgerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        ArrayList<MenuItem> burgerItems = new ArrayList<MenuItem>();
        burgerItems.add(new MenuItem("Donut", "1.6", R.drawable.beefnonion));
        burgerItems.add(new MenuItem("Eclair", "2.0-2.1", R.drawable.butterchicken));
        burgerItems.add(new MenuItem("Froyo", "2.2-2.2.3", R.drawable.cheesygarlic));
        burgerItems.add(new MenuItem("GingerBread", "2.3-2.3.7", R.drawable.chickenfajita));
        burgerItems.add(new MenuItem("Honeycomb", "3.0-3.2.6", R.drawable.eightmeats));
        burgerItems.add(new MenuItem("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.beefnonion));
        burgerItems.add(new MenuItem("Jelly Bean", "4.1-4.3.1", R.drawable.cheesygarlic));
        burgerItems.add(new MenuItem("KitKat", "4.4-4.4.4", R.drawable.butterchicken));
        burgerItems.add(new MenuItem("Lollipop", "5.0-5.1.1", R.drawable.eightmeats));
        burgerItems.add(new MenuItem("Marshmallow", "6.0-6.0.1", R.drawable.butterchicken));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        MenuItemAdaptor burgerAdapter = new MenuItemAdaptor(this, burgerItems);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_item);
        listView.setAdapter(burgerAdapter);
    }
    }

