package com.example.android.foodpanda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SweetMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        ArrayList<MenuItem> sweetItems = new ArrayList<MenuItem>();
        sweetItems.add(new MenuItem("Donut", "1.6", R.drawable.beefnonion));
        sweetItems.add(new MenuItem("Eclair", "2.0-2.1", R.drawable.butterchicken));
        sweetItems.add(new MenuItem("Froyo", "2.2-2.2.3", R.drawable.cheesygarlic));
        sweetItems.add(new MenuItem("GingerBread", "2.3-2.3.7", R.drawable.chickenfajita));
        sweetItems.add(new MenuItem("Honeycomb", "3.0-3.2.6", R.drawable.eightmeats));
        sweetItems.add(new MenuItem("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.beefnonion));
        sweetItems.add(new MenuItem("Jelly Bean", "4.1-4.3.1", R.drawable.cheesygarlic));
        sweetItems.add(new MenuItem("KitKat", "4.4-4.4.4", R.drawable.butterchicken));
        sweetItems.add(new MenuItem("Lollipop", "5.0-5.1.1", R.drawable.eightmeats));
        sweetItems.add(new MenuItem("Marshmallow", "6.0-6.0.1", R.drawable.butterchicken));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        MenuItemAdaptor sweetAdaptor = new MenuItemAdaptor(this, sweetItems);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_item);
        listView.setAdapter(sweetAdaptor);
    }
}
