package test.aws.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static String AUTH_TOKEN_HEADER_NAME;
    private static String AUTH_TOKEN;

    @Value("${api-key.header}")
    public void setHeader(String value) {
        AUTH_TOKEN_HEADER_NAME = value;
    }

    @Value("${api-key.key}")
    public void setKey(String value) {
        AUTH_TOKEN = value;
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
