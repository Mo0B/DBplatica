package com.example.DBPostgre.Controller;

import lombok.RequiredArgsConstructor;
import com.example.DBPostgre.Model.mInquilino;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sInquilino;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inquilino/")
public class cInquilino {
    private final sInquilino inquilinoS;

    @GetMapping("all")
    public List<mInquilino> getAllInquilinos() {
        return inquilinoS.getAllInquilinos();
    }

    @GetMapping("byId/{id}")
    public Optional<mInquilino> getInquilinoById(@PathVariable long id) {
        return inquilinoS.getInquilinoById(id);
    }

    @PostMapping("create")
    public mInquilino createInquilino(@RequestBody mInquilino inquilino) {
        return inquilinoS.createInquilino(inquilino);
    }

    @PutMapping("update/{id}")
    public mInquilino updateInquilino(@PathVariable long id, @RequestBody mInquilino inquilino) {
        return inquilinoS.updateInquilino(id, inquilino);
    }

    @DeleteMapping("delete/{id}")
    public void deleteInquilino(@PathVariable long id) {
        inquilinoS.deleteInquilino(id);
    }


}
