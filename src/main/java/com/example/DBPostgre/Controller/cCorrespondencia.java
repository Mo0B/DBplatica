package com.example.DBPostgre.Controller;

import com.example.DBPostgre.Model.mInquilino;
import com.example.DBPostgre.Service.sInquilino;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sCorrespondencia;
import com.example.DBPostgre.Model.mCorrespondencia;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/correspondencia")
public class cCorrespondencia {
private final sCorrespondencia correspondenciaS;

    @GetMapping("all")
    public List<mCorrespondencia> getAllCorrespondencias() {
        return correspondenciaS.getAllCorrespondencias();
    }

    @GetMapping("byId/{id}")
    public Optional<mCorrespondencia> getCorrespondenciaById(@PathVariable long id) {
        return correspondenciaS.getCorrespondenciaById(id);
    }

    @PostMapping("create")
    public mCorrespondencia createCorrespondencia(@RequestBody mCorrespondencia correspondencia) {
        return correspondenciaS.createCorrespondencia(correspondencia);
    }

    @PutMapping("update/{id}")
    public mCorrespondencia updateCorrespondencia(@PathVariable long id, @RequestBody mCorrespondencia correspondencia) {
        return correspondenciaS.updateCorrespondencia(id, correspondencia);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCorrespondencia(@PathVariable long id) {
        correspondenciaS.deleteCorrespondencia(id);
    }

}
