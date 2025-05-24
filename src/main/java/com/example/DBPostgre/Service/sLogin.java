package com.example.DBPostgre.Service;
import com.example.DBPostgre.Model.mVigilante;
import com.example.DBPostgre.Repository.rVigilante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class sLogin {
    @Autowired
    private rVigilante vigilanteRepository;

    @Autowired
    private JwtService jwtService;

    public String login(String usuario, String contra) {
        mVigilante vigilante = vigilanteRepository.findByUsuario(usuario);
        if (vigilante != null && vigilante.getContra().equals(contra)) {
            return jwtService.generateToken(vigilante);
        }
        return null;
    }
}
