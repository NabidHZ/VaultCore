package com.vaultcore.cuentas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public Cuenta crearCuenta(String numeroCuenta, Long usuarioId) {
        if (cuentaRepository.findByNumeroCuenta(numeroCuenta).isPresent()) {
            throw new IllegalArgumentException("El número de cuenta ya existe");
        }

        Cuenta nuevaCuenta = Cuenta.builder()
                .numeroCuenta(numeroCuenta)
                .usuarioId(usuarioId)
                .saldo(BigDecimal.ZERO)
                .build();

        return cuentaRepository.save(nuevaCuenta);
    }

    public Cuenta obtenerCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la cuenta: " + numeroCuenta));
    }
}