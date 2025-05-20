package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mObra;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sObra;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/obra")
public class cObra {
    private final sObra obraS;

    @GetMapping("all")
    public List<mObra> getAllObras() {
        return obraS.getAllObras();
    }

    @GetMapping("byId/{id}")
    public Optional<mObra> getObraById(@PathVariable long id) {
        return obraS.getObraById(id);
    }

    @PostMapping("create")
    public mObra createObra(@RequestBody mObra obra) {
        return obraS.createObra(obra);
    }

    @PutMapping("update/{id}")
    public mObra updateObra(@PathVariable long id, @RequestBody mObra obra) {
        return obraS.updateObra(id, obra);
    }

    @DeleteMapping("delete/{id}")
    public void deleteObra(@PathVariable long id) {
        obraS.deleteObra(id);
    }


}
