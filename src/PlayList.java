import java.util.*;

/**
 * Created by sesion on 03/05/2016.
 */
public class PlayList {

    private String name;
    private ArrayList<FilmTestClass> playlist = new ArrayList<FilmTestClass>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FilmTestClass> getplaylist() {
        return playlist;
    }

    public void setplaylist(ArrayList<FilmTestClass> playlist) {
        this.playlist = playlist;
    }

    public PlayList() {
        name = "Untitled";
        playlist = new ArrayList<FilmTestClass>();
    }

    public PlayList(String name) {
        this.name = name;
        playlist = new ArrayList<FilmTestClass>();
    }



    public void introduceFilm(FilmTestClass film, int position){
        playlist.add(position, film);
    }

    public void introduceFilm(FilmTestClass film){
        playlist.add(film);
    }

    public void removeFilm(int pos){
        playlist.remove(pos);

    }

    public void replaceFilm(int pos, FilmTestClass film){
        playlist.remove(pos);
        playlist.add(pos, film);
    }




}
