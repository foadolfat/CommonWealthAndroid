package com.example.commonwealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ViewProject extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView[] textView= new TextView[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);
        Intent intent = getIntent();
        String searchTerm = intent.getStringExtra(MainActivity.EXTRA_SEARCH_TERM);
        textView[0] = findViewById(R.id.project_name_textview);
        textView[1] = findViewById(R.id.name_textview);
        textView[2] = findViewById(R.id.location_textview);
        textView[3] = findViewById(R.id.num_of_helpers_textview);

        db.collection("Projects").whereEqualTo("projectName", searchTerm)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            CWProject recieving = new CWProject();
                            recieving = documentSnapshot.toObject(CWProject.class);
                            textView[0].setText(recieving.getProjectName());
                            textView[1].setText(recieving.getName());
                            textView[2].setText(recieving.getLocation());
                            textView[3].setText("" + recieving.getNumOfHelpers());

                        }


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ViewProject.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void search_docs(String searchTerm){ ;
        db.collection("Projects").whereEqualTo("projectName", searchTerm)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            CWProject recieving = new CWProject();
                            recieving = documentSnapshot.toObject(CWProject.class);
                            textView[0].setText(recieving.getProjectName());
                            textView[1].setText(recieving.getName());
                            textView[2].setText(recieving.getLocation());
                            textView[3].setText("" + recieving.getNumOfHelpers());

                        }


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ViewProject.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}