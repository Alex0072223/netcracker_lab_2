package com.example.netcracker_lab_2.service;

import com.example.netcracker_lab_2.converters.GenreCommandToGenre;
import com.example.netcracker_lab_2.converters.GenreToGenreCommand;
import com.example.netcracker_lab_2.domain.Genre;
import com.example.netcracker_lab_2.repositiry.GenreRepository;
import org.apache.catalina.Service;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {

    private final GenreToGenreCommand genreToGenreCommand;
    private final GenreCommandToGenre genreCommandToGenre;

    @Mock
    GenreRepository genreRepository;
    GenreService genreService;

    GenreServiceImplTest() {
        this.genreToGenreCommand = new GenreToGenreCommand();
        this.genreCommandToGenre = new GenreCommandToGenre();
    }


    @BeforeEach
    void setUp() {
        genreService = new GenreServiceImpl(genreRepository, genreToGenreCommand, genreCommandToGenre);
    }

    @Test
    void findAll() {
        when(genreRepository.findAll()).thenReturn(Arrays.asList(
                Genre.builder().id(1).build(),
                Genre.builder().id(2).build()
        ));

        List<Genre> genreList = genreService.findAll();

        Assertions.assertEquals(2, genreList.size());
        Assertions.assertEquals(1, genreList.get(0).getId());
        Assertions.assertEquals(2, genreList.get(1).getId());

        verify(genreRepository, times(1)).findAll();
    }

    @Test
    void findAllByNameLikeAlternative() {//Dizzy
        when(genreService.findAllByNameLikeAlternative(any())).thenReturn(List.of(
                Genre.builder().id(1).build(),
                 Genre.builder().id(2).build()
        ));

        List<Genre> genreList = genreService.findAllByNameLikeAlternative(any());

        Assertions.assertEquals(1,genreList.size());
        Assertions.assertEquals(1, genreList.get(0).getId());

        verify(genreService, times(1)).findAllByNameLikeAlternative(any());

    }

    @Test
    void findAllByNameLike() { //Dizzy
        when(genreRepository.findAllByNameLike(any())).thenReturn(List.of(
                Genre.builder().name("name").build(),
                Genre.builder().name("other name").build()
        ));

        List<Genre> genreList = genreService.findAllByNameLike(any());

        Assertions.assertEquals(2, genreList.size());
        Assertions.assertEquals("name",genreList.get(0).getName());
        Assertions.assertEquals("other name",genreList.get(1).getName());

        verify(genreRepository, times(1)).findAllByNameLike(any());
    }

    @Test
    void findById() {
        when(genreRepository.findById(1)).thenReturn(Optional.of(Genre.builder().id(1).build()));

        Genre genre = genreService.findById(1);
        Genre nullGenre = genreService.findById(2);

        Assertions.assertEquals(1, genre.getId());
        Assertions.assertNull(nullGenre);

        verify(genreRepository, times(2)).findById(anyInt());
    }

    @Test
    void saveGenreCommand() {
    }

    @Test
    void deleteById() {
        genreRepository.deleteById(anyInt());
        verify(genreService,times(1)).deleteById(anyInt());

       // doNothing().when(genreService).deleteById(id);
       // doReturn(List.of(Genre.builder().id(1).build())).when(genreRepository).deleteById(1);

    }

    @Test
    void findCommandById() {
        genreCommandToGenre.convert(any());

        verify(genreService, times(1)).findCommandById(any());

    }
}