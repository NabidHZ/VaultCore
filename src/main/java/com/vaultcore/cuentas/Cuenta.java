package com.vaultcore.cuentas;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String numeroCuenta;

    @Column(nullable = false)
    private Long usuarioId; // Simulamos a quién pertenece sin hacer otra tabla aún

    // NUNCA uses Double o Float para dinero. Siempre BigDecimal.
    @Column(nullable = false)
    private BigDecimal saldo;

    
    // Evita que dos transacciones modifiquen el saldo al mismo milisegundo.
    @Version
    private Long version;
}