package com.example.netcracker_lab_2;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import com.example.netcracker_lab_2.domain.Genre;
import com.example.netcracker_lab_2.domain.Track;
import com.example.netcracker_lab_2.repositiry.GenreRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.Optional;


@Stateless
public class SesBns {
    public void sayHi() throws JAXBException {
        GenreRepository gr = new GenreRepository() {
            @Override
            public <S extends Genre> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Genre> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Genre> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Genre> findAll() {
                return null;
            }

            @Override
            public Iterable<Genre> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Genre entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Genre> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public Optional<Genre> findByName(String name) {
                return Optional.empty();
            }

            @Override
            public List<Genre> findAllByNameLike(String template) {
                return null;
            }
        };


        Track tr = new Track();
        for (int i = 1; i != 4; i++) {
            tr.setId(i);

            tr.setName("Montero");
            tr.setAlbum("Monstro");
            tr.setAuthor("Lil NasX");
            tr.setDuration(181);
            tr.setGenre(gr.findByName("rap").orElse(null));
            //(genreRepository.findByName("rap").orElse(null));

            File XmlFile = new File("src/main/resources/Jaxb/parcer.xml");

            JAXBContext context = JAXBContext.newInstance(Track.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(tr, XmlFile);
            marshaller.marshal(tr, System.out);


        }
    }
}