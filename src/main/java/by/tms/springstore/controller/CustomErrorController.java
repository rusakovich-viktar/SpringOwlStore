//package by.tms.springstore.controller;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CustomErrorController implements ErrorController {
//
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        // Получите информацию об ошибке из запроса
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        // Обработайте различные типы ошибок и верните соответствующее представление
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                // Обработка ошибки 404 (страница не найдена)
//                return "error-404";
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                // Обработка внутренней серверной ошибки
//                return "error-500";
//            }
//            // Другие обработки ошибок, если необходимо
//        }
//        // Если не удалось определить тип ошибки, верните общую страницу ошибки
//        return "error";
//    }
//
//    public String getErrorPath() {
//        // Возвращаем путь для обработки ошибок
//        return "/error";
//    }
//}