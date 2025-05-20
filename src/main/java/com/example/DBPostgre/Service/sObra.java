package com.example.DBPostgre.Service;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Repository.rInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DBPostgre.Model.mObra;
import com.example.DBPostgre.Repository.rObra;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class sObra {

    @Autowired
    private rObra obraR;

    public List<mObra> getAllObras() {
        return obraR.findAll();
    }

    public Optional<mObra> getObraById(long id) {
        return obraR.findById(id);
    }

    public mObra createObra(mObra obra) {
        return obraR.save(obra);
    }

    public mObra updateObra(long id, mObra obra) {
        return obraR.findById(id).map(obraExistente -> {
            obraExistente.setNombre(obra.getNombre());
            obraExistente.setApellido(obra.getApellido());
            obraExistente.setTelefono(obra.getTelefono());
            obraExistente.setNum_Documento(obra.getNum_Documento());
            obraExistente.setTipo(obra.getTipo());
            obraExistente.setInquilino(obra.getInquilino());
            return obraR.save(obraExistente);
        }).orElseThrow(() -> new RuntimeException("Propietario no encontrado con id: " + id));
    }

    public void deleteObra(long id) {
        if (obraR.existsById(id)) {
            obraR.deleteById(id);
        }
    }

}
