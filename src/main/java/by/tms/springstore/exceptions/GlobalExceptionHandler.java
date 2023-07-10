package by.tms.springstore.exceptions;

import static by.tms.springstore.utils.Constants.PagePath.ERROR_500;

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

    //
    //    <SC> User findBy, accountEnableStatus, updateUser,
    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("userNotFoundException", e.getMessage());
        log.error("UserNotFoundException", e);
        return modelAndView;
    }

    //    <SC> User findBy
    @ExceptionHandler(UserNotFoundByEmailException.class)
    public ModelAndView handleUserNotFoundByEmailException(UserNotFoundByEmailException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("userNotFoundByEmailException", e.getMessage());
        log.error("userNotFoundByEmailException", e);
        return modelAndView;
    }

    //getCollectRefProductsByIds
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleWindowNotFoundException(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("productNotFoundException", e.getMessage());
        log.error("productNotFoundException", e);
        return modelAndView;
    }

    //Проверен
    @ExceptionHandler(InvalidUserPasswordException.class)
    public ModelAndView handleInvalidUserPasswordException(InvalidUserPasswordException e) {
        ModelAndView modelAndView = new ModelAndView("/auth/change-password");
        modelAndView.addObject("invalidOldPasswordException", e.getMessage());
        log.error("invalidOldPasswordException", e);
        return modelAndView;
    }

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/error");
        modelAndView.addObject("message", e.getMessage());
        log.error("Exception", e);
        return modelAndView;
    }

}