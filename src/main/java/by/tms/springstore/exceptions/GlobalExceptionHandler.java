package by.tms.springstore.exceptions;

import static by.tms.springstore.utils.Constants.Attributes.INVALID_OLD_PASSWORD_EXCEPTION;
import static by.tms.springstore.utils.Constants.Attributes.PRODUCT_NOT_FOUND_EXCEPTION;
import static by.tms.springstore.utils.Constants.Attributes.USER_NOT_FOUND_BY_EMAIL_EXCEPTION;
import static by.tms.springstore.utils.Constants.Attributes.USER_NOT_FOUND_EXCEPTION;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_CHANGE_PASSWORD;
import static by.tms.springstore.utils.Constants.PagePath.ERROR_500;
import static by.tms.springstore.utils.Constants.PagePath.ERROR_GENERAL_PAGE;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataAccessException(DataAccessException e) {
        log.error("DataAccess exception", e);
        return new ModelAndView(ERROR_500);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView(ERROR_GENERAL_PAGE);
        modelAndView.addObject(USER_NOT_FOUND_EXCEPTION, e.getMessage());
        log.error(USER_NOT_FOUND_EXCEPTION, e);
        return modelAndView;
    }

    @ExceptionHandler(UserNotFoundByEmailException.class)
    public ModelAndView handleUserNotFoundByEmailException(UserNotFoundByEmailException e) {
        ModelAndView modelAndView = new ModelAndView(ERROR_GENERAL_PAGE);
        modelAndView.addObject(USER_NOT_FOUND_BY_EMAIL_EXCEPTION, e.getMessage());
        log.error(USER_NOT_FOUND_BY_EMAIL_EXCEPTION, e);
        return modelAndView;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleWindowNotFoundException(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView(ERROR_GENERAL_PAGE);
        modelAndView.addObject(PRODUCT_NOT_FOUND_EXCEPTION, e.getMessage());
        log.error(PRODUCT_NOT_FOUND_EXCEPTION, e);
        return modelAndView;
    }

    @ExceptionHandler(InvalidUserPasswordException.class)
    public ModelAndView handleInvalidUserPasswordException(InvalidUserPasswordException e) {
        ModelAndView modelAndView = new ModelAndView(AUTH_CHANGE_PASSWORD);
        modelAndView.addObject(INVALID_OLD_PASSWORD_EXCEPTION, e.getMessage());
        log.error(INVALID_OLD_PASSWORD_EXCEPTION, e);
        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/error");
        modelAndView.addObject("message", e.getMessage());
        log.error("Exception", e);
        return modelAndView;
    }

}
