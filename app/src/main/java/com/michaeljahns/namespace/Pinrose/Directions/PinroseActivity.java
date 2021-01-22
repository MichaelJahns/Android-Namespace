package com.michaeljahns.namespace.Pinrose.Directions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.michaeljahns.namespace.R;

public class PinroseActivity extends Fragment {

    Button North, South, East, West, NorthEast, SouthEast, SouthWest, NorthWest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pinrose, container, false);
        bindButtons(view);


        North.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigationStab_to_north);
            }
        });
        South.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigationStab_to_south);
            }
        });
        East.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_east);
            }
        });
        West.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_west);
            }
        });
        NorthEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_northEast);
            }
        });
        SouthEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_southEast);
            }
        });
        SouthWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_southWest);
            }
        });
        NorthWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_pinrose_to_northWest);
            }
        });
        ConstraintLayout layout = (ConstraintLayout) view.findViewById(R.id.d);

        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setFillAfter(true);
        animation.setDuration(3600);
        layout.startAnimation(animation);

        return view;
    }

    public void bindButtons(View view) {
        North = view.findViewById(R.id.ferryNorth);
        East = view.findViewById(R.id.ferryEast);
        South = view.findViewById(R.id.ferrySouth);
        West = view.findViewById(R.id.ferryWest);
        NorthEast = view.findViewById(R.id.ferryNorthEast);
        SouthEast = view.findViewById(R.id.ferrySouthEast);
        SouthWest = view.findViewById(R.id.ferrySouthWest);
        NorthWest = view.findViewById(R.id.ferryNorthWest);
    }

}
