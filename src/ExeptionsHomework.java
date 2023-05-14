public class ExeptionsHomework {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth("login", "1234", "1234");
            System.out.println("Реистрация пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Регистрация не пройдена");
        }
    }
    private static void checkAuth (String login, String pass, String confirmPass) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!pass.matches(REGEX) || pass.length() > 20 || !pass.equals(confirmPass)) {
            throw new WrongPasswordException();
        }
    }
}
