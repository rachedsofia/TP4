package model;

import domain.portsin.DomainException;
import domain.portsin.NuevaInscripcion;
import domain.portsin.ParticipanteRecord;
import domain.portsout.InfraestructureException;
import domain.portsout.Inscripciones;

public class DefaultNuevaInscripcion implements NuevaInscripcion {
	private Inscripciones registro;

	public DefaultNuevaInscripcion(Inscripciones registro) {
		this.registro = registro;
	}

	public void registrar(ParticipanteRecord participante) throws DomainException, InfraestructureException {
		Participante nuevoParticipante = new Participante(participante.nombre(), participante.telefono(),
				participante.region());

		registro.registrar(nuevoParticipante.getNombre(), nuevoParticipante.getTelefono(),
				nuevoParticipante.getRegion());

	}
}
