package model;

import java.util.Objects;

import domain.portsin.DomainException;

public class Telefono {
	private String telefono;

	public Telefono(String numeroTelefono) throws DomainException {
		Objects.requireNonNull(numeroTelefono);

		if (numeroTelefono.isEmpty() || numeroTelefono.isBlank()) {
			throw new DomainException("El campo de telefono esta vacio");
		}

		validarTelefono(numeroTelefono);

		this.telefono = numeroTelefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	private void validarTelefono(String telefono) throws DomainException {
		String regex = "\\d{4}-\\d{6}";

		if (!telefono.matches(regex)) {
			throw new DomainException("El tel�fono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
	}

}
