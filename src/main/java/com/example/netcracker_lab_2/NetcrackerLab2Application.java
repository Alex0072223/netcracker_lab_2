package com.example.netcracker_lab_2;


import com.example.netcracker_lab_2.bootstrap.DataLoader;
import com.example.netcracker_lab_2.commands.TrackCommand;
import com.example.netcracker_lab_2.domain.Track;
import com.example.netcracker_lab_2.service.TrackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;

@SpringBootApplication
public class NetcrackerLab2Application {

    public static void main(String[] args) throws JAXBException {




       // Song song = new Song();
        /*List <Track> tr = new ArrayList<>();


        DL track = new DL();
         track.setId(1);
        track.setAuthor("sssssssssssssssssssssssss");
        track.setAlbum("sssssssssssssssssssssssss");
        track.setName("sssssssssssssssssssssssss");
        track.setDuration(2222222);




        File XmlFile = new File("src/main/resources/Jaxb/parcer.xml");

        JAXBContext context = JAXBContext.newInstance(DL.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(track, XmlFile);
        marshaller.marshal(track, System.out);*/

        SpringApplication.run(NetcrackerLab2Application.class, args);

//        System.out.println(tr.get(track.getId()));


    }


}
