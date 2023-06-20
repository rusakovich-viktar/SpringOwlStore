package by.tms.springstore.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    @UtilityClass
    public class Attributes {
        public static final String USER_UUID = "userUUID";
        public static final String CART = "cart";
        public static final String USERNAME = "username";
        public static final String CATEGORIES = "categories";
        public static final String PRODUCTS = "products";
        public static final String NAME_CATEGORY = "nameCategory";
        public static final String MY_PRODUCTS = "myProducts";
        public static final String SUCCESS_REGISTRATION = "successRegistration";
        public static final String ERROR_REGISTRATION = "errorRegistration";

        public static final String ONE_PRODUCT = "oneProduct";
        public static final String PRODUCT = "product";
        public static final String USER_DTO = "userDto";
        public static final String USER_ID = "userId";

        public static final String USER = "user";
        public static final String TOTAL_PRICE = "totalPrice";
    }

    @UtilityClass
    public class RequestParams {
        public static final String PRODUCT_ID = "productId";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String REPEAT_PASS = "repeatPass";
        public static final String SURNAME = "surname";
        public static final String BIRTHDAY = "date";
        public static final String GENDER = "gender";
        public static final String EMAIL = "email";
        public static final String REGISTRATION_DATE = "registrationDate";
        public static final String ID = "id";
//        public static final String IMAGE_PATH = "imagePath";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String PRICE_PARAMETER = "price";
        public static final String CATEGORY_ID = "categoryId";
        public static final String NAME_CATEGORY = "nameCategory";
        public static final String ACTION = "action";


    }

    @UtilityClass
    public class PagePath {
        public static final String SIGN_IN = "signin";
        public static final String LOGIN = "login";
        public static final String AUTH_LOGIN = "auth/login";
        public static final String AUTH_REGISTRATION = "auth/registration";
        public static final String SIGN_UP = "signup";

        public static final String HOME = "home";
        public static final String CART = "cart";
        public static final String REDIRECT_TO_HOME = "redirect:/home";
        public static final String PROFILE = "profile";
        public static final String CATEGORY = "category";
        public static final String PRODUCT = "product";
        public static final String REDIRECT_TO_PRODUCT = "redirect:/product";
        public static final String REDIRECT_TO_PROFILE = "redirect:/profile";
        public static final String REDIRECT_TO_CART = "redirect:/cart";

        public static final String EDIT_PROFILE = "edit-profile";

    }

}
