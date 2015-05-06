package kaylamacfarlane.cuttingboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquivalentsFragment extends Fragment {
    private String[] equivalentsArray = {"Teaspoon (tsp)",
           "1/16 tsp = A dash",
           "1/8 tsp = A pinch",
           "1 tsp = (&#8531;) tsp",
           "3 tsp = 1 tbsp",
           "Tablespoon (tbsp)",
           "(&#189;) tbsp = 1 (&#189;) tsp",
           "2 tbsp = 1/8 cup",
           "3 tbsp = 1 (&#189;) ounce",
           "4 tbsp = (&#188;) cup",
           "5 tbsp + 1 tsp = (&#8531;) cup",
           "8 tbsp = (&#189;) cup",
           "10 tbsp + 2tsp = 2/3 cup",
           "12 tbsp = (&#190;) cup",
           "16 tbsp = 1 cup OR (&#189;) pint",
           "Cup",
           "1/8 cup 2 tbsp",
           "(&#188;) cup 4 tbsp",
           "(&#8531;) cup = 5 tbsp + 1 tsp",
           "3/8 cup = (&#188;) cup + 2 tsp",
           "(&#189;) cup = 8 tbsp",
           "2/3 cup = 10 tbsp + 2 tsp",
           "5/8 = (&#189;) cup + 2 tbsp",
           "(&#190;) cup = 12 tbsp",
           "7/8 cup = (&#190;) cup + 2 tbsp",
           "1 cup = 16 tbsp OR (&#189;) pint",
           "2 cups = 1 pint",
           "3 cups = 1 (&#189;) pint",
           "4 cups = 1 quart",
           "8 cups = 2 quarts",
           "Pint",
           "1 pint = 2 cups",
           "2 pints = 1 quart",
           "Quart",
           "1 quart = 2 pints OR 4 cups",
           "4 quarts = 1 gallon",};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_equivalents, container, false);

        return rootView;
    }
}
