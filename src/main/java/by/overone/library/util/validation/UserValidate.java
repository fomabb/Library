package by.overone.library.util.validation;

import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserRegistrationDTO;
import by.overone.library.util.validation.exception.ValidateException;

public class UserValidate {

    private final static String LOGIN_REGEX = "^[\\w]{4,12}$";
    private final static String EMAIL_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";
    private final static String PASSWORD_REGEX = "[a-zA-Z0-9]{2,16}";
    private final static String PHONE_REGEX = "^(\\+375|29)(17|29|33|44)(\\d){7}$";
    private final static String NAME_REGEX = "^[a-zA-Z]{2,30}$";
    private final static String ADDRESS_REGEX = "^[\\w]{5,50}$";

    public static boolean validateRegistration(UserRegistrationDTO user) throws ValidateException {
        return validateLogin(user.getLogin()) && validateEmail(user.getEmail()) && validatePassword(user.getPassword());
    }

    public static boolean validateUserDetails(UserDetailsDTO user) throws ValidateException {
        return validateName(user.getUser_details_name()) && validateSurname(user.getUser_details_surname())
                && validateAddress(user.getUser_details_address())
                && validatePhoneNumber(user.getUser_details_phonenumber());
    }

    private static boolean validateLogin(String login) throws ValidateException {
        if (login != null && !login.isBlank() && login.matches(LOGIN_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validatePassword(String password) throws ValidateException {
        if (password != null && !password.isBlank() && password.matches(PASSWORD_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validateEmail(String email) throws ValidateException {
        if (email != null && !email.isBlank() && email.matches(EMAIL_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validatePhoneNumber(String phoneNumber) throws ValidateException {
        if (phoneNumber != null && !phoneNumber.isBlank() && phoneNumber.matches(PHONE_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validateName(String name) throws ValidateException {
        if (name != null && !name.isBlank() && name.matches(NAME_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validateSurname(String surName) throws ValidateException {
        if (surName != null && !surName.isBlank() && surName.matches(NAME_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }

    private static boolean validateAddress(String address) throws ValidateException {
        if (address != null && !address.isBlank() && address.matches(ADDRESS_REGEX)) {
            return true;
        } else {
            throw new ValidateException("Data entered incorrectly");
        }
    }
}

