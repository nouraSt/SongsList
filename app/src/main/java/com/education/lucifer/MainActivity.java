package com.education.lucifer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Music> mymusic;
    private MusicAdapter my_adapter;
    private ListView listview_songs;
    private TextView txt;
    private DatabaseReference ProductsRef;
    private ArrayList<String> tracks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview_songs = findViewById(R.id.list);
        txt = (TextView) findViewById(R.id.lucy);
        mymusic = new ArrayList<Music>();
        tracks = new ArrayList<String>();

        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Tracks");
        ProductsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    if(dataSnapshot.child("links").exists()){
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            tracks.add(String.valueOf(data.child("links").getValue())); //add result into array list

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         mymusic.add(new Music("Track1","artist1", tracks.get(0)));
        MusicAdapter my_adapter = new MusicAdapter(this,R.layout.song_item,mymusic,getLayoutInflater());
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
