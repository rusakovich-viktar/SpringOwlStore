package by.tms.springstore.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    @UtilityClass
    public class Attributes {
        public static final String CART = "cart";
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String BIRTHDAY = "birthday";
        public static final String PASSWORD = "password";
        public static final String CATEGORIES = "categories";
        public static final String PRODUCTS = "products";
        public static final String NAME_CATEGORY = "nameCategory";
        public static final String SUCCESS_REGISTRATION = "successRegistration";
        public static final String ERROR_REGISTRATION = "errorRegistration";
        public static final String MESSAGE = "message";
        public static final String ONE_PRODUCT = "oneProduct";
        public static final String SEARCH_RESULTS = "searchResults";
        public static final String USER_DTO = "userDto";
        public static final String USER = "user";
        public static final String USERS = "users";
        public static final String CURRENT_PAGE = "currentPage";
        public static final String TOTAL_PAGES = "totalPages";
        public static final String TOTAL_ITEMS = "totalItems";
        public static final String MESSAGE_ACTIVATION_SUCCESS = "Поздравляю. Активация прошла успешно. Теперь вы можете войти.";
        public static final String MESSAGE_ACTIVATION_ERROR = "Ошибка активации. Пожалуйста, свяжитесь с администратором.";
        public static final String MESSAGE_SEND_SUCCESS = "Ваше сообщение успешно отправлено!";
        public static final String CONTACT_FORM = "contactForm";
        public static final String SUCCESS_MESSAGE = "successMessage";
        public static final String PASSWORD_FORM = "passwordForm";
        public static final String USER_NOT_FOUND = "User not found ";
        public static final String NOT_FOUND = " not found";
        public static final String EMAIL_PATTERN = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        public static final String PHONE_PATTERN = "^\\+375(17|25|29|33|44)[0-9]{3}[0-9]{2}[0-9]{2}$";

    }

    @UtilityClass
    public class RequestParams {
        public static final String PRODUCT_ID = "productId";
        public static final String QUERY = "query";
        public static final String EMAIL = "email";
        public static final String PAGE = "page";
        public static final String SIZE = "size";

    }

    @UtilityClass
    public class PagePath {
        public static final String SEARCH_RESULTS_PATH = "search-results";
        public static final String AUTH_LOGIN = "auth/login";
        public static final String AUTH_REGISTRATION = "auth/registration";
        public static final String HOME = "home";
        public static final String CART = "cart";
        public static final String PROFILE = "profile";
        public static final String CATEGORY = "category";
        public static final String PRODUCT = "product";
        public static final String REDIRECT_TO_PROFILE = "redirect:/user/profile/";
        public static final String REDIRECT_ADMIN_ALL = "redirect:/admin/all";
        public static final String REDIRECT_TO_CART = "redirect:/cart";
        public static final String EDIT_PROFILE = "edit-profile";
        public static final String ADMIN_USERLIST = "/admin/userlist";
        public static final String ADMIN_ADMINPANEL = "/admin/admin-panel";
        public static final String REDIRECT_AUTH_LOGIN_LOGOUT = "redirect:/auth/login?logout";
        public static final String CONTACTS = "contacts";
        public static final String ABOUT_US = "about-us";
        public static final String AUTH_USER_AGREEMENT = "auth/user-agreement";
        public static final String REDIRECT_PRODUCT = "redirect:/product/";
        public static final String ADDED_TRUE = "?added=true";
        public static final String AUTH_RESET_PASSWORD = "/auth/reset-password";
        public static final String AUTH_CHANGE_PASSWORD = "/auth/change-password";
        public static final String AUTH_CHANGE_PASSWORD_SUCCESS = "/auth/change-password-success";
        public static final String ERROR_403 = "/error/error-403";
        public static final String ERROR_500 = "/error/error-500";
        public static final String ERROR = "redirect:/error-general";

    }

    @UtilityClass
    public class VariableValues {
        public static final String PAGE_NUMBER_REQUESTED = "0";
        public static final String SIZE_OF_THE_ELEMENTS_ON_THE_PAGE = "3";
        public static final int MINIMUM_QUERY_LENGTH_TO_SEARCH = 2;
        public static final int MINIMUM_AGE_TO_REGISTRATION = 14;
    }

}
