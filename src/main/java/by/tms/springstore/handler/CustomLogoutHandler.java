package by.tms.springstore.handler;

import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_AUTH_LOGIN_LOGOUT;

import by.tms.springstore.security.CustomUserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomLogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        log.info("The user with a login " + principal.getUser().getUsername() + " logged out.");
        response.sendRedirect(REDIRECT_AUTH_LOGIN_LOGOUT);
    }
}
