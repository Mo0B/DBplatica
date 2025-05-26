package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mVigilante;
import com.example.DBPostgre.Repository.rVigilante;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.Authentication;

@RequiredArgsConstructor
@Service
public class sVigilante {

    @Autowired
    private rVigilante vigilanteR;

    public List<mVigilante> getAllVigilantes() {
        return vigilanteR.findAll();
    }

    public Optional<mVigilante> getVigilanteById(long id) {
        return vigilanteR.findById(id);
    }

    public mVigilante createVigilante(mVigilante vigilante) {
        return vigilanteR.save(vigilante);
    }

    public mVigilante updateVigilante(long id, mVigilante vigilante) {
        if (vigilanteR.existsById(id)) {
            vigilante.setId(id);
            return vigilanteR.save(vigilante);
        } else {
            return null;
        }
    }

    public void deleteVigilante(long id) {
        if (vigilanteR.existsById(id)) {
            vigilanteR.deleteById(id);
        }
    }

    public Optional<mVigilante> buscarPorUsuario(String usuario) {
        return vigilanteR.findByUsuario(usuario);
    }

    public mVigilante getLoggedVigilante() {

        String username = obtenerUsernameDelContextoDeSeguridad();


        return vigilanteR.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Vigilante no encontrado"));
    }

    private String obtenerUsernameDelContextoDeSeguridad() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        throw new RuntimeException("Usuario no autenticado");
    }

}
