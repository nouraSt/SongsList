package com.education.lucifer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Music> mymusic;
    private MusicAdapter my_adapter;
    private ListView listview_songs;
    private TextView txt;
    private ArrayList<String> tracks;
    private DatabaseReference ProductsRef;
    private MediaPlayer mediaPlayer;

    //private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private DocumentReference noteRef = db.document("links");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview_songs = findViewById(R.id.list);
        txt = (TextView) findViewById(R.id.lucy);
        mymusic = new ArrayList<Music>();
        tracks = new ArrayList<String>();

        mymusic.add(new Music("Track2","x1",R.raw.track1));
        mymusic.add(new Music("Track3","x2",R.raw.track2));





        MusicAdapter my_adapter = new MusicAdapter(this,R.layout.song_item,mymusic,getLayoutInflater(), mediaPlayer);
        listview_songs.setAdapter(my_adapter);
        //mymusic.add(new Music("Track2","lucifer",R.raw.track2));
        //mymusic.add(new Music("Track3","lucifer",R.raw.track3));
        //mymusic.add(new Music("Track4","lucifer",R.raw.track4));
       // mymusic.add(new Music("Track5","lucifer",R.raw.track5));
       // mymusic.add(new Music("Track6","lucifer",R.raw.track6));
       // mymusic.add(new Music("Track7","lucifer",R.raw.track7));
        //mymusic.add(new Music("Track8","lucifer",R.raw.track8));
       // mymusic.add(new Music("Track9","lucifer",R.raw.track9));
        //mymusic.add(new Music("Track10","lucifer",R.raw.track10));
       // mymusic.add(new Music("Track11","lucifer",R.raw.track11));
      //  mymusic.add(new Music("Track12","lucifer",R.raw.track12));
       // mymusic.add(new Music("Track13","lucifer",R.raw.track13));
       // mymusic.add(new Music("Track14","lucifer",R.raw.track14));
      //  mymusic.add(new Music("Track15","lucifer",R.raw.track15));
      //  mymusic.add(new Music("Track16","lucifer",R.raw.track16));
      //  mymusic.add(new Music("Track17","lucifer",R.raw.track17));
      //  mymusic.add(new Music("Track18","lucifer",R.raw.track18));
      //  mymusic.add(new Music("Track19","lucifer",R.raw.track19));
     //   mymusic.add(new Music("Track20","lucifer",R.raw.track20));
     //   mymusic.add(new Music("Track21","lucifer",R.raw.track21));







        // mymusic.add(new Music("Track2","lucifer",R.raw.track2));


        //mymusic.add(new Music("Track3","lucifer",R.raw.track3));

    }
}
