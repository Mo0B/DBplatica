package com.example.DBPostgre.Service;
import com.example.DBPostgre.Model.mVigilante;
import com.example.DBPostgre.Repository.rVigilante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class sLogin {
    @Autowired
    private rVigilante vigilanteRepository;

    @Autowired
    private JwtService jwtService;

    public String login(String usuario, String contra) {
        Optional<mVigilante> vigilanteOpt = vigilanteRepository.findByUsuario(usuario);

        if (vigilanteOpt.isPresent()) {
            mVigilante vigilante = vigilanteOpt.get();
            if (vigilante.getContra().equals(contra)) {
                return jwtService.generateToken(Optional.of(vigilante));
            }
        }
        return null;
    }

}
