package com.vaultcore.cuentas;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaController {


    private final CuentaService cuentaService;

    // POST: Para crear datos (Enviar dinero o crear cuentas)
    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody CrearCuentaRequest request) {
        Cuenta cuentaCreada = cuentaService.crearCuenta(request.numeroCuenta(), request.usuarioId());
        // Devuelve un código 201 (Created) estándar en APIs REST
        return new ResponseEntity<>(cuentaCreada, HttpStatus.CREATED);
    }

    // GET: Para consultar datos (Ver el saldo)
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable String numeroCuenta) {
        Cuenta cuenta = cuentaService.obtenerCuenta(numeroCuenta);
        // Devuelve un código 200 (OK)
        return ResponseEntity.ok(cuenta);
    }
}