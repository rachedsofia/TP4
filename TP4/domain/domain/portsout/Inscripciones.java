package domain.portsout;

public interface Inscripciones {

	public void registrar(String nombre, String numeroTelefono, String region) throws InfraestructureException;
}
