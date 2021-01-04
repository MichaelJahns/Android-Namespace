package com.michaeljahns.namespace.Pinrose.Directions;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.michaeljahns.namespace.GlobalApplication;
import com.michaeljahns.namespace.R;
import com.michaeljahns.namespace.grammy.PirateLocation;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
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
//        fileWrite();
        Context context = GlobalApplication.getAppContext();
        try {
            fileWrite(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public String getDataDir(Context context) throws Exception {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir;
    }

    public void readJson(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\java\\com\\michaeljahns\\namespace\\json\\pirateLocations.json"));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            Mapper mapper =  DozerBeanMapperBuilder.buildDefault();
            PirateLocation pirateLocation = mapper.map(jsonObject, PirateLocation.class);
            System.out.println(pirateLocation);
            priateText.setText(pirateLocation.getLocation());
            reader.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void fileWrite(Context context) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("location", "Pirate Bay");
        String FILE_NAME = "saved.txt";
        try{
            String userString = object.toString();
// Define the File Path and its Name
            File file = new File(context.getFilesDir(),FILE_NAME);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();

        }catch(Exception e){
        }
    }
}