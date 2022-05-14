package com.example.netcracker_lab_2;


import com.example.netcracker_lab_2.domain.Genre;
import com.example.netcracker_lab_2.domain.Track;
import com.example.netcracker_lab_2.repositiry.GenreRepository;
import com.example.netcracker_lab_2.service.TrackService;
import com.example.netcracker_lab_2.service.TrackServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Jaxb {

    private final static String baseFile = "user.json";

    public static void toJSON(ToJSON element) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), element);
        System.out.println("json created!");
    }

    public static ToJSON toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), ToJSON.class);
    }

    public static void main(String[] args) throws JAXBException, IOException {

        ToJSON user = new ToJSON();
        user.setId(1);
        user.setName("Monster");
        user.setAlbum("Monstro");
        user.setAuthor("Lil NasX");
        toJSON(user);





       // toJavaObject();






//        SesBns sb = new SesBns();
//        sb.sayHi();


































       /* GenreRepository gr = new GenreRepository() {
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


        Track tr  = new Track();
        for (int i=1;i !=4;i++) {
            tr.setId(i);

            tr.setName("Lil NN");
            tr.setAlbum("Monstro");
            tr.setAuthor("");
            tr.setDuration(181);
            tr.setGenre(gr.findByName("rap").orElse(null));
            //(genreRepository.findByName("rap").orElse(null));

            File XmlFile = new File("src/main/resources/Jaxb/parcer.xml");

            JAXBContext context = JAXBContext.newInstance(Track.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(tr, XmlFile);
            marshaller.marshal(tr, System.out);*/

//        }







    }
}
