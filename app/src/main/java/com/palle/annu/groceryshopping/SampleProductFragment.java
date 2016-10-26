package com.palle.annu.groceryshopping;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleProductFragment extends Fragment implements View.OnClickListener {

    String[] options = {"Add new","View All", "Apple", "Grapes", "Orange",
            "Pears"};

    FruitFragment fruitFragment;

    TextView main_fruits,main_vegetables,main_diary,main_grains,main_spices,main_misc;
    public SampleProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_categories, container, false);
        fruitFragment = new FruitFragment();
        initializeViews(v);
        return v;
    }

    private void initializeViews(View viewGroup) {
        main_fruits = (TextView) viewGroup.findViewById(R.id.fruitsTxt);
        main_vegetables = (TextView) viewGroup.findViewById(R.id.vegetablesTxt);
        main_diary = (TextView) viewGroup.findViewById(R.id.diaryTxt);
        main_grains = (TextView) viewGroup.findViewById(R.id.grainsTxt);
        main_spices = (TextView) viewGroup.findViewById(R.id.spicesTxt);
        main_misc = (TextView) viewGroup.findViewById(R.id.miscTxt);

        main_fruits.setOnClickListener(this);
        main_vegetables.setOnClickListener(this);
        main_diary.setOnClickListener(this);
        main_grains.setOnClickListener(this);
        main_spices.setOnClickListener(this);
        main_misc.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fruitsTxt:
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container1, fruitFragment);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.vegetablesTxt:

                break;
            case R.id.diaryTxt:

                break;
            case R.id.grainsTxt:

                break;
            case R.id.spicesTxt:

                break;
            case R.id.miscTxt:

                break;
            default:
                break;
        }
    }
}
