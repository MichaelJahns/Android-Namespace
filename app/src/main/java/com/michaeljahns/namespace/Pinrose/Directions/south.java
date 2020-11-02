package com.michaeljahns.namespace.Pinrose.Directions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.michaeljahns.namespace.R;

public class south extends Fragment {
    public south() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_south, container, false);
        view.findViewById(R.id.textSouth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_south_to_navigationStab);
            }
        });
        view.findViewById(R.id.ferryBounce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_south_to_bounce2);
            }
        });
        return view;
    }
}