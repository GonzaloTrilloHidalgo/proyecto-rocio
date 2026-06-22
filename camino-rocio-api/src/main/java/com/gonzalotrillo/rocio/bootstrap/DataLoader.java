package com.gonzalotrillo.rocio.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzalotrillo.rocio.model.Hermandad;
import com.gonzalotrillo.rocio.model.Parada;
import com.gonzalotrillo.rocio.repository.HermandadRepository;
import com.gonzalotrillo.rocio.repository.ParadaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    private final HermandadRepository hermandadRepo;
    private final ParadaRepository paradaRepo;
    private final ObjectMapper objectMapper;

    public DataLoader(HermandadRepository hermandadRepo, ParadaRepository paradaRepo, ObjectMapper objectMapper) {
        this.hermandadRepo = hermandadRepo;
        this.paradaRepo = paradaRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (hermandadRepo.count() == 0) {
            log.info("Cargando hermandades desde JSON...");
            InputStream is = new ClassPathResource("data/hermandades.json").getInputStream();
            List<Hermandad> hermandades = objectMapper.readValue(is, new TypeReference<>() {});
            hermandadRepo.saveAll(hermandades);
            log.info("Cargadas {} hermandades", hermandades.size());
        }

        if (paradaRepo.count() == 0) {
            log.info("Cargando paradas desde JSON...");
            InputStream is = new ClassPathResource("data/paradas.json").getInputStream();
            List<Parada> paradas = objectMapper.readValue(is, new TypeReference<>() {});
            paradaRepo.saveAll(paradas);
            log.info("Cargadas {} paradas", paradas.size());
        }
    }
}
