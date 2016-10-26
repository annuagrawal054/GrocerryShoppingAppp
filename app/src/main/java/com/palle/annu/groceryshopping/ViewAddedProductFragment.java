package com.palle.annu.groceryshopping;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewAddedProductFragment extends Fragment {
ListView listViewItemAdded;
    MyGroceryDataBase myGroceryDataBase;

    public ViewAddedProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_view_added_product, container, false);
        listViewItemAdded = (ListView)v.findViewById(R.id.list_items_added);
        myGroceryDataBase = new MyGroceryDataBase(getActivity());
        myGroceryDataBase.open();

        Cursor cursor = myGroceryDataBase.getItem();
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),R.layout.row,cursor,new String[]{"_id","item","quantity","quantity_unit"},new int[]{R.id.tv_id,R.id.tv_item_name,R.id.tv_quantity,R.id.tv_unit});
        listViewItemAdded.setAdapter(simpleCursorAdapter);

        return v;

    }

}
