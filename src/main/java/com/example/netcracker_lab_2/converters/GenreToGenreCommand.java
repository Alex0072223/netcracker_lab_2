package com.example.netcracker_lab_2.converters;

import com.example.netcracker_lab_2.commands.GenreCommand;
import com.example.netcracker_lab_2.domain.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converter class
 */
@Component
public class GenreToGenreCommand implements Converter<Genre, GenreCommand> {

    /**
     * Converts {@link Genre} to {@link GenreCommand}
     */
    @Override
    public GenreCommand convert(Genre source) {
        return source == null ? null : GenreCommand.builder()
                .id(source.getId())
                .name(source.getName())
                .build();

    }
}
