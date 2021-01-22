package com.example.commonwealth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewProject extends AppCompatActivity {
    private Button button;
    EditText projectName;
    EditText name;
    EditText location;
    EditText numOfHelpers;
    CWProject new_project;
    private String latlng = "";


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_project);
        Intent intent = getIntent();
        button = findViewById(R.id.button2);
        projectName = (EditText) findViewById(R.id.project_name);
        name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.location);
        numOfHelpers = (EditText) findViewById(R.id.num_of_help);
        location.setFocusable(false);
        Places.initialize(getApplicationContext(), "AIzaSyCkBBUzJ5XLH3gkDAocLHbBJGHhMnnAe0o");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                createProject();
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS
                        ,Place.Field.LAT_LNG,Place.Field.NAME);

                Intent intent2 = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                        ,fieldList).build(CreateNewProject.this);

                startActivityForResult(intent2,100);
            }
        });
    }
    public void createProject(){

        String nameStr = name.getText().toString();

        new_project = new CWProject();
        new_project.setProjectName(projectName.getText().toString());
        new_project.setName(name.getText().toString());
        new_project.setLocation(location.getText().toString());
        new_project.setLatLng(latlng);
        new_project.setNumOfHelpers(Integer.valueOf(numOfHelpers.getText().toString()));



        db.collection("Projects").document(nameStr).set(new_project)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(CreateNewProject.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CreateNewProject.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){

            Place place = Autocomplete.getPlaceFromIntent(data);
            location.setText(place.getAddress());
            latlng = String.valueOf(place.getLatLng());

        }
        else if(resultCode == AutocompleteActivity.RESULT_ERROR){
            Status status = Autocomplete.getStatusFromIntent(data);

            Toast.makeText(getApplicationContext(),status.getStatusMessage()
            ,Toast.LENGTH_SHORT).show();
        }

    }


}