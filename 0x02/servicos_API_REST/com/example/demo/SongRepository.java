package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<>();
    private int nextId = 1;

    public SongRepository() {
        list.add(new Song(nextId++, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(nextId++, "Imagine", "John Lennon", "Imagine","1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        for (Song song : list) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null; // Retorna null se a música não for encontrada
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        for (int i = 0; i < list.size(); i++) {
            Song song = list.get(i);
            if (song.getId().equals(s.getId())) {
                list.set(i, s); // Atualiza a música na lista
                return; // Sai do método após atualizar
            }
        }
        // Se a música não for encontrada, você pode lançar uma exceção ou fazer outra ação.
    }

    public void removeSong(Song s) {
        list.remove(s);  // Remove a música da lista usando o método equals da classe Song.
    }

    public void removeSongById(Integer id) { // Método adicional para remover por ID.
        list.removeIf(song -> song.getId().equals(id));
    }
}
