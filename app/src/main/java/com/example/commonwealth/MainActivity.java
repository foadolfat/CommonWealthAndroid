package com.example.commonwealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SEARCH_TERM = "com.example.commonwealth.SEARCH_TERM";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button button;
    private Button search;
    private FirebaseAuth mAuth;

    TextView[] textView= new TextView[5];
    /*
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
     */


    EditText search_docs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        search = findViewById(R.id.button3);
        textView[0] = findViewById(R.id.textView);
        textView[1] = findViewById(R.id.textView2);
        textView[2] = findViewById(R.id.textView3);
        textView[3] = findViewById(R.id.textView4);
        textView[4] = findViewById(R.id.textView5);
        search_docs = findViewById(R.id.search_docs);

        db.collection("Projects").whereGreaterThan("numOfHelpers", 1)
                .orderBy("numOfHelpers", Query.Direction.DESCENDING)
                .limit(5)
                //.document(search_docs.getText()
                //.toString())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        int i=0;
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            CWProject recieving = new CWProject();
                            recieving = documentSnapshot.toObject(CWProject.class);
                            textView[i].setText(recieving.getProjectName());
                            i++;
                        }

                        //textView4.setText(recieving.getNumOfHelpers());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });



        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              Add_project();
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_docs(search_docs.getText().toString());

            }
        });
    }
    /** Called when the user taps the Add button */
    public void Add_project() {
        Intent intent = new Intent(this, CreateNewProject.class);
        startActivity(intent);
    }

    public void search_docs(String searchTerm){

        Intent intent = new Intent(this, ViewProject.class);
        intent.putExtra(EXTRA_SEARCH_TERM, searchTerm);
        startActivity(intent);
        /*
        db.collection("Projects").whereEqualTo("projectName", search_docs.getText().toString())
                //.document(search_docs.getText()
                //.toString())
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
                            textView[4].setText("");
                        }

                        //textView4.setText(recieving.getNumOfHelpers());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });

         */
    }

}


/*
db.collection("Projects")
                .document(search_docs.getText().toString())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            //String project1 = documentSnapshot.getString("project_name");
                            CWProject recieving = new CWProject();
                            recieving = documentSnapshot.toObject(CWProject.class);
                            textView.setText(recieving.getProjectName());
                            textView2.setText(recieving.getName());
                            textView3.setText(recieving.getLocation());
                            //textView4.setText(recieving.getNumOfHelpers());
                        }else{
                            Toast.makeText(MainActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });
 */