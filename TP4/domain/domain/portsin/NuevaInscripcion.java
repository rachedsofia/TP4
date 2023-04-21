package domain.portsin;

import domain.portsout.InfraestructureException;

public interface NuevaInscripcion {
	public void registrar(ParticipanteRecord participante) throws DomainException, InfraestructureException;
}
