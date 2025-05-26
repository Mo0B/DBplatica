package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mEntrada;
import com.example.DBPostgre.Model.mVisitante;
import com.example.DBPostgre.Model.requesEntrada;
import com.example.DBPostgre.Model.requestVisitante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sVisitante;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/visitante")
public class cVisitante {
    private final sVisitante visitanteS;


    @PostMapping("registrar")
    public ResponseEntity<mVisitante> registrarVisita(@RequestBody requestVisitante request) {
        mVisitante vistanteCreado = visitanteS.registrarVisita(request);
        return ResponseEntity.ok(vistanteCreado);
    }

    @GetMapping("all")
    public List<mVisitante> getAllVisitantes() {
        return visitanteS.getAllVisitantes();
    }

    @GetMapping("byId/{id}")
    public Optional<mVisitante> getVisitanteById(@PathVariable long id) {
        return visitanteS.getVisitanteById(id);
    }

    @PostMapping("create")
    public mVisitante createVisitante(@RequestBody mVisitante visitante) {
        return visitanteS.createVisitante(visitante);
    }

    @PutMapping("update/{id}")
    public mVisitante updateVisitante(@PathVariable long id, @RequestBody mVisitante visitante) {
        return visitanteS.updateVisitante(id, visitante);
    }

    @DeleteMapping("delete/{id}")
    public void deleteVisitante(@PathVariable long id) {
        visitanteS.deleteVisitante(id);
    }


}
