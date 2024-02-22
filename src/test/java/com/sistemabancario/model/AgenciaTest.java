package com.sistemabancario.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgenciaTest {
    Banco banco;
    Agencia agencia;

    @BeforeEach
    void setup() {
        // setup
        banco = new Banco();
        agencia = new Agencia(banco);
    }

    @Test
    void testSetNumero() {
        // Setup
        String numeroAgencia = "8602-9";

        // exercise
        agencia.setNumero(numeroAgencia);

        // Verify
        assertEquals(agencia.getNumero(), numeroAgencia);

        // Teardown
    }

    @Test
    void testNumeroAgenciaInvalido() {
        // Setup
        String numeroAgencia = "1234-5";

        // Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> agencia.setNumero(numeroAgencia));

        assertEquals("Dígito final inválido. Deve estar no formato 0638-6", exception.getMessage());

    }

    @Test
    void testNumeroAgenciaNulo() {
        // Setup
        String numeroAgencia = null;

        // Verify
        assertThrows(NullPointerException.class, () -> agencia.setNumero(numeroAgencia));

    }
}
