package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Bem-vindo ao serviço de músicas!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Integer id) {
        Optional<Song> song = Optional.ofNullable(songRepository.getSongById(id));
        if (song.isPresent()) {
            return ResponseEntity.ok(song.get());
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return ResponseEntity.status(HttpStatus.CREATED).body(song); // Retorna 201 Created
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> updateSong(@RequestBody Song song) {
        try {
            songRepository.updateSong(song);
            return ResponseEntity.ok(song); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
    }


    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> deleteSongById(@RequestBody Song song) {
        try {
            songRepository.removeSong(song);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) { // Captura exceções genéricas (melhor especificar)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }
}