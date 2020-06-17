/*
 *
 */
package com.sirius.security;

import com.alibaba.fastjson.JSONObject;
import com.sirius.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Will run when user login username and pass word validate successfully.
 * There will generate a token return to response.
 */
@Service("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    //    @Autowired
//    private JwtTokenProvider tokenProvider;
    @Resource
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException {
        logger.info("User: " + authentication.getName() + " Login successfully.");
        this.returnJson(response, authentication);
    }

    private void returnJson(HttpServletResponse response, Authentication authentication) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        StringBuilder currentAuthorityBuilder = new StringBuilder();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            currentAuthorityBuilder.append(authority.getAuthority());
        }
        LoginSuccessVo loginSuccessVo = new LoginSuccessVo();
        loginSuccessVo.setCurrentAuthority(currentAuthorityBuilder.toString());
        response.getWriter().println(JSONObject.toJSONString(loginSuccessVo));
    }

    private class LoginSuccessVo {
        private String status = "ok";
        private String currentAuthority;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCurrentAuthority() {
            return currentAuthority;
        }

        public void setCurrentAuthority(String currentAuthority) {
            this.currentAuthority = currentAuthority;
        }
    }


}