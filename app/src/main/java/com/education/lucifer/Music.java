package com.education.lucifer;

public class Music {
    private String songName;
    private String artist;
    private String songs;

    public Music(String songName, String artist, String songs){
        this.songName = songName;
        this.artist = artist;
        this.songs = songs;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }
}
