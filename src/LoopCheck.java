public class LoopCheck implements CharacterCheck {
    private static final String
            VALID_SYMBOLS = "0123456789_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    @Override
    public void stringValidation(String s, boolean login)
                                     throws WrongLoginException,WrongPasswordException {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_SYMBOLS.contains(String.valueOf(s.charAt(i)))) {
                if (login){
                    throw new WrongLoginException("Логин может содержать только цифры, " +
                                                 "символы латинского алфавита и знак подчеркивания !");
                } else {
                   throw  new WrongPasswordException("Пароль может содержать только цифры, " +
                                                  "символы латинского алфавита и знак подчеркивания !");
                }
            }
        }

    }
}
