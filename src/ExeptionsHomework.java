public class ExeptionsHomework {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth("loginё", "1234", "123");
            System.out.println("Реистрация пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Регистрация не пройдена");
            System.out.println(e.getMessage());
        }
    }
    private static void checkAuth (String login, String pass, String confirmPass) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX) || login.length() > 20) {
            throw new WrongLoginException("Ошибка в логине");
        }
        if (!pass.matches(REGEX) || pass.length() > 20 || !pass.equals(confirmPass)) {
            throw new WrongPasswordException("Ошибка в пароле");
        }
    }
}
