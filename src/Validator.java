import java.util.Objects;

public class Validator {

    private Validator() { // запрещаем создавать объект от данного класса
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            chek(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static void chek(String login,
                             String password,
                             String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login == null || login.isEmpty() || login.length() >= 20) {
            throw new WrongLoginException("Введите правильно логин, а так же длинна логина должна"
                    + " быть меньше 20 знаков !");
        }
        LoopCheck loopCheck = new LoopCheck();
        loopCheck.stringValidation(login, true);
        if (password == null || password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException("Введите правильно пароль, а так же длинна пароля должна"
                    + " быть меньше 20 знаков !");
        }
        loopCheck.stringValidation(password, false);
        loopCheck.stringValidation(confirmPassword, false);
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("пароль и проверка пароля должны совпадать !");
        }


    }
}
