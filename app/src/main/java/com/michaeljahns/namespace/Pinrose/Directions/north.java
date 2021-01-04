package com.michaeljahns.namespace.Pinrose.Directions;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michaeljahns.namespace.GlobalApplication;
import com.michaeljahns.namespace.R;
import com.michaeljahns.namespace.grammy.Location;
import com.michaeljahns.namespace.grammy.LocationLayoutAdapter;
import com.michaeljahns.namespace.grammy.Tracery;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class north extends Fragment {
    private RecyclerView locationRecycler;
    private Button locationBtn;

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
        View view = inflater.inflate(R.layout.fragment_north, container, false);
        bindView(view);
        final Context context = GlobalApplication.getAppContext();
        final String JSON = readJsonFromAsset(context);
        List<Location> locations = getLocations(JSON);
        startRecycler(locations, context);
        return view;
    }

    public List<Location> getLocations(String Json) {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String locationName = Tracery.flattenJSON(Json);
            Location location = new Location(locationName);
            locations.add(location);
        }
        return locations;
    }

    public void startRecycler(List<Location> locations, Context context) {
        LocationLayoutAdapter locationLayoutAdapter = new LocationLayoutAdapter(context, locations);
        this.locationRecycler.setAdapter(locationLayoutAdapter);
        this.locationRecycler.setLayoutManager(new LinearLayoutManager(context));
    }

    public void bindView(View view) {
        locationBtn = view.findViewById(R.id.pirateLocationBtn);
        locationRecycler = view.findViewById(R.id.locationRecycler);

        view.findViewById(R.id.textNorth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_north_to_navigationStab);
            }
        });

    }

    public String readJsonFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("pirateLocations.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            return null;
        }
        return json;
    }
}