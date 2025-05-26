package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mEntrada;
import com.example.DBPostgre.Model.requesEntrada;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sEntrada;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entrada")
public class cEntrada {
    private final sEntrada entradaS;
    @PostMapping("registrar")
    public ResponseEntity<mEntrada> registrarEntrada(@RequestBody requesEntrada request) {
        mEntrada entradaCreada = entradaS.registrarEntrada(request);
        return ResponseEntity.ok(entradaCreada);
    }
    @GetMapping("all")
    public List<mEntrada> getAllEntradas() {
        return entradaS.getAllEntradas();
    }

    @GetMapping("byId/{id}")
    public Optional<mEntrada> getEntradaById(@PathVariable long id) {
        return entradaS.getEntradaById(id);
    }

    @PostMapping("create")
    public mEntrada createEntrada(@RequestBody mEntrada entrada) {
        return entradaS.createEntrada(entrada);
    }

    @PutMapping("update/{id}")
    public mEntrada updateEntrada(@PathVariable long id, @RequestBody mEntrada entrada) {
        return entradaS.updateEntrada(id, entrada);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEntrada(@PathVariable long id) {
        entradaS.deleteEntrada(id);
    }

}
