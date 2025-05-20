package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mVigilante;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sVigilante;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vigilante")
public class cVigilante {
    private final sVigilante vigilanteS;

    @GetMapping("all")
    public List<mVigilante> getAllVigilantes() {
        return vigilanteS.getAllVigilantes();
    }

    @GetMapping("byId/{id}")
    public Optional<mVigilante> getVigilanteById(@PathVariable long id) {
        return vigilanteS.getVigilanteById(id);
    }

    @PostMapping("create")
    public mVigilante createVigilante(@RequestBody mVigilante vigilante) {
        return vigilanteS.createVigilante(vigilante);
    }

    @PutMapping("update/{id}")
    public mVigilante updateVigilante(@PathVariable long id, @RequestBody mVigilante vigilante) {
        return vigilanteS.updateVigilante(id, vigilante);
    }

    @DeleteMapping("delete/{id}")
    public void deleteVigilante(@PathVariable long id) {
        vigilanteS.deleteVigilante(id);
    }



}
