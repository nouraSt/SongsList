package com.education.lucifer;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Music> musicArrayList;
    private LayoutInflater inflate;
    private Boolean flag=true;
    private MediaPlayer mediaPlayer;
    private String LOG_TAG= "yes";

    public MusicAdapter(Context context, int layout, ArrayList<Music> musicArrayList, LayoutInflater inflate ){
        this.context=context;
        this.layout=layout;
        this.musicArrayList=musicArrayList;
        this.inflate=inflate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int getCount() {
        return musicArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflate.inflate(R.layout.song_item, parent, false);
        TextView textHead = (TextView) convertView.findViewById(R.id.song);
        final ImageView img1= (ImageView) convertView.findViewById(R.id.playy);
        final ImageView img2 = (ImageView) convertView.findViewById(R.id.stop);
        final TextView title = (TextView) convertView.findViewById(R.id.song);


        textHead.setText(musicArrayList.get(position).getSongName());
        if(convertView == null){
            convertView= convertView;
        }else{

        }

        final Music music = musicArrayList.get(position);
        textHead.setText(music.getSongName());

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer= new MediaPlayer();

                if (flag) {
                    try {
                        mediaPlayer.setDataSource(music.getSongs());
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "prepare() failed");
                    }


                      //  mediaPlayer.create(context,music.getSongs());

                    // mediaPlayer.start();
                    flag= false;
                }
                if(mediaPlayer!= null && mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    img1.setImageResource(R.drawable.ic_pause_black_24dp);

                }else{
                    mediaPlayer.start();
                    img1.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
                mediaPlayer.start();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                img2.setImageResource(R.drawable.ic_stop_black_24dp);

            }
        });


        return convertView;

    }


}
