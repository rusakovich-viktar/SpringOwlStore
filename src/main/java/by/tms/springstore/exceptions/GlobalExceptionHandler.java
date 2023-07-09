package by.tms.springstore.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    //    <SC> User findBy, accountEnableStatus, updateUser,
    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("userNotFoundException", e.getMessage());
        return modelAndView;
    }

    //    <SC> User findBy
    @ExceptionHandler(UserNotFoundByEmailException.class)
    public ModelAndView handleUserNotFoundByEmailException(UserNotFoundByEmailException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("userNotFoundByEmailException", e.getMessage());
        return modelAndView;
    }

    //getCollectRefProductsByIds
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleWindowNotFoundException(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error-general");
        modelAndView.addObject("productNotFoundException", e.getMessage());
        return modelAndView;
    }

    //Проверен
    @ExceptionHandler(InvalidUserPasswordException.class)
    public ModelAndView handleInvalidUserPasswordException(InvalidUserPasswordException e) {
        ModelAndView modelAndView = new ModelAndView("/auth/change-password");
        modelAndView.addObject("invalidOldPasswordException", e.getMessage());
        return modelAndView;
    }

}
