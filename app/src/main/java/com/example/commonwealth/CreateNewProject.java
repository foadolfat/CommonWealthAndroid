package com.example.commonwealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateNewProject extends AppCompatActivity {
    private Button button;
    EditText projectName;
    EditText name;
    EditText location;
    EditText numOfHelpers;
    CWProject new_project;


    //Firerstore initial test
    private static final String KEY_PROJECT_NAME = "project_name";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_NUM_OF_HELP = "num_of_help";

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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                createProject();
            }
        });
    }
    public void createProject(){
        new_project = new CWProject();
        new_project.setProjectName(projectName.getText().toString());
        new_project.setName(name.getText().toString());
        new_project.setLocation(location.getText().toString());
        new_project.setNumOfHelpers(Integer.valueOf(numOfHelpers.getText().toString()));
        //print_object();



       //Firerstore initial test
        String projectNameStr = projectName.getText().toString();
        String nameStr = name.getText().toString();
        String locationStr = location.getText().toString();
        String numOfHelpersStr = numOfHelpers.getText().toString();

        Map<String,Object> project_hash = new HashMap<>();
        project_hash.put(KEY_PROJECT_NAME, projectNameStr);
        project_hash.put(KEY_NAME, nameStr);
        project_hash.put(KEY_LOCATION, locationStr);
        project_hash.put(KEY_NUM_OF_HELP, numOfHelpersStr);

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
    public void print_object(){
        /*
        System.out.println("Name of project is " + new_project.projectName);
        System.out.println("Name of owner is " + new_project.name);
        System.out.println("Address of project is " + new_project.location);
        System.out.println("Number of required helpers is " + new_project.numOfHelpers);

        showToast(new_project.projectName);
        showToast(new_project.name);
        showToast(new_project.location);

         */
    }
    private void showToast(String text){
        Toast.makeText(CreateNewProject.this,text, Toast.LENGTH_SHORT).show();
    }
}