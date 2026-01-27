package exceptions;

public class NomePetInvalidoException extends RuntimeException {
    public NomePetInvalidoException(String message) {
        super(message);
    }
}
