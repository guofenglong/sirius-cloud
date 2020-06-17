/*
 *
 */
package com.sirius.security;

import org.springframework.security.core.context.SecurityContextImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengyoule
 */
public class UserSecurityContext {

    public static String getUserLoginName(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
                .getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContextImpl == null) {
            return null;
        }
        return securityContextImpl.getAuthentication().getName();
    }
}
