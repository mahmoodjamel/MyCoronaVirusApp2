package com.ahmed00.mycoronavirusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class CoronaVirusActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_virus);

        firestore = FirebaseFirestore.getInstance();

        ImageView imageView = findViewById(R.id.imageView00);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/chatapp-db313.appspot.com/o/uploads%2F1.png?alt=media&token=e3b5e52f-485c-4a74-baf0-a3d8058b3858").into(imageView);

        VideoView videoView = findViewById(R.id.videoView1);
        MediaController mediaController =new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/chatapp-db313.appspot.com/o/uploads%2FPrevention%20of%20COVID-19%20in%20the%20Workplace.mp4?alt=media&token=081655ac-2522-4844-ac89-e52a0c05498b");
        videoView.setVideoURI(uri);
        videoView.start();

        final TextView textView = findViewById(R.id.textView100);

        CollectionReference reference1 = firestore.collection("corona_virus");
        Task<QuerySnapshot> q1 = reference1.get();
        q1.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {

                    TextCorona t = queryDocumentSnapshot.toObject(TextCorona.class);
                    textView.setText(t.getTextCorona());

                }
            }
        });


    }
}
