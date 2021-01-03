package com.michaeljahns.namespace.Pinrose.Directions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.michaeljahns.namespace.R;
import com.michaeljahns.namespace.grammy.PirateLocation;


import java.io.Reader;
import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class north extends Fragment {
    private Button pirateButton;
    private TextView priateText;

    public north() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_north, container, false);
        pirateButton = view.findViewById(R.id.pirateLocationBtn);
        readJson();
        pirateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readJson();
            }
        });
        priateText = view.findViewById(R.id.pirateLocationText);
        view.findViewById(R.id.textNorth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_north_to_navigationStab);
            }
        });

        return view;
    }

    public void readJson(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get("json\\pirateLocations.json"));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            Mapper mapper =  DozerBeanMapperBuilder.buildDefault();
            PirateLocation pirateLocation = mapper.map(jsonObject, PirateLocation.class);
            System.out.println(pirateLocation);
            priateText.setText(pirateLocation.getLocation());
            reader.close();
        }catch(Exception e){
            System.out.println(e);
        }


    }
}