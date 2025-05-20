package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.mMantenimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.DBPostgre.Service.sMantenimiento;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mantenimiento")
public class cMantenimiento {
    private final sMantenimiento mantenimientoS;

    @GetMapping("all")
    public List<mMantenimiento> getAllMantenimientos() {
        return mantenimientoS.getAllMantenimientos();
    }

    @GetMapping("byId/{id}")
    public Optional<mMantenimiento> getMantenimientoById(@PathVariable long id) {
        return mantenimientoS.getMantenimientoById(id);
    }

    @PostMapping("create")
    public mMantenimiento createMantenimiento(@RequestBody mMantenimiento mantenimiento) {
        return mantenimientoS.createMantenimiento(mantenimiento);
    }

    @PutMapping("update/{id}")
    public mMantenimiento updateMantenimiento(@PathVariable long id, @RequestBody mMantenimiento mantenimiento) {
        return mantenimientoS.updateMantenimiento(id, mantenimiento);
    }

    @DeleteMapping("delete/{id}")
    public void deleteMantenimiento(@PathVariable long id) {
        mantenimientoS.deleteMantenimiento(id);
    }


}
