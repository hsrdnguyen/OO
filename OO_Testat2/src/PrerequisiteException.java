public class PrerequisiteException extends Exception {
    public PrerequisiteException() {
        super("Circular reference: Module prerequisites reference each other so some modules can not be visited.");
    }
}
