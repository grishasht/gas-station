package ua.kpi.dziuba.gasstation.security;

public class SecurityConstants {

    public static final String SECRET = "yViJ63ChCnzQ36fghRQBvxtrVNiH0CZvWrMHQmxj31EbDg7ApF8lqpZuZ5gJ46g5";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/guest/sign-up";
    public static final String SIGN_IN_URL = "/guest/sign-in";

    public static final String GUEST_URLS = "/guest/**";
}
