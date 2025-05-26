package com.example.DBPostgre.Controller;
import com.example.DBPostgre.Model.VigilanteMapper;
import com.example.DBPostgre.Model.mVigilante;
import com.example.DBPostgre.Model.mVigilanteDTO;
import com.example.DBPostgre.Service.sLogin;
import com.example.DBPostgre.Service.sVigilante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class cLogin {
    @Autowired
    private sLogin loginService;
    private final sVigilante vigilanteS;

    @Autowired
    public cLogin(sLogin loginService, sVigilante vigilanteS) {
        this.loginService = loginService;
        this.vigilanteS = vigilanteS;
    }


    public static class LoginRequest {
        public String usuario;
        public String contra;
    }

    public static class LoginResponse {
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = loginService.login(request.usuario, request.contra);
        if (token != null) {
            return ResponseEntity.ok(new LoginResponse(token));
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
    @GetMapping("/vigilante/me")
    public ResponseEntity<mVigilanteDTO> getVigilanteLogueado() {
        mVigilante vigilante = vigilanteS.getLoggedVigilante();
        mVigilanteDTO dto = VigilanteMapper.toDto(vigilante);
        return ResponseEntity.ok(dto);
    }

}
