package com.palle.annu.groceryshopping;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
j */
public class AddProductFragment extends Fragment {
    EditText etEnterItem,etEnterQuantity;
    Button bAddToCart;
    Spinner spUnit;
    String[] unit ={"kg","gram","ml","litre"};
    ArrayAdapter mArrayAdapter;
    MyGroceryDataBase mGroceryDataBase;

    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_product, container, false);
        etEnterItem = (EditText)v.findViewById(R.id.et_enter_item);
        etEnterQuantity = (EditText)v.findViewById(R.id.et_enter_quantity);
        spUnit = (Spinner)v.findViewById(R.id.sp_unit);
        bAddToCart = (Button)v.findViewById(R.id.b_add_to_cart);
        mArrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,unit);
        spUnit.setAdapter(mArrayAdapter);

        mGroceryDataBase = new MyGroceryDataBase(getActivity());
        mGroceryDataBase.open();

        spUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final String quantity_unit_position = unit[i];
                bAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String item = etEnterItem.getText().toString();
                        int quantity = Integer.parseInt(etEnterQuantity.getText().toString());
                        String price = " " +0;
                        mGroceryDataBase.insertgrocery(item,quantity,quantity_unit_position,price);
                        mGroceryDataBase.open();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

}
