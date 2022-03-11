package demo.cloud.common.core.common.security;

import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;

public class AuthUserContext {


    private static final ThreadLocal<UserInfoInTokenBo> USER_INFO_IN_TOKEN_HOLDER = new ThreadLocal<>();

    public static UserInfoInTokenBo get() {
        return USER_INFO_IN_TOKEN_HOLDER.get();
    }

    public static void set(UserInfoInTokenBo userInfoInTokenBo) {
        USER_INFO_IN_TOKEN_HOLDER.set(userInfoInTokenBo);
    }

    public static void clean() {
        if (USER_INFO_IN_TOKEN_HOLDER.get() != null) {
            USER_INFO_IN_TOKEN_HOLDER.remove();
        }
    }

}
