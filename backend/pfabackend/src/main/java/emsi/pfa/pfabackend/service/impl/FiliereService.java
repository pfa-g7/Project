package emsi.pfa.pfabackend.service.impl;

import emsi.pfa.pfabackend.entity.Filiere;
import emsi.pfa.pfabackend.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    public Filiere save(Filiere filiere) {
        filiere.setLibelle(filiere.getLibelle().replaceAll("\\s", ""));
        Optional<Filiere> loadedFiliere = filiereRepository.findByLibelle(filiere.getLibelle());
        if (loadedFiliere.isPresent()) return loadedFiliere.get();
        return filiereRepository.save(filiere);
    }
}
