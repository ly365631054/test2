package org.custom;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.junit.platform.commons.util.StringUtils;

/**
 * @Author yong.li_1
 **/
public class CustomRealm extends AuthorizingRealm {

    {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashedCredentialsMatcher);
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        if (StringUtils.isBlank(username)) {
            return null;
        }

        // 模拟取用户信息
        User user = findUserByUsername(username);


        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), null,"CustomRealm");
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        return info;
    }

    private User findUserByUsername(String username) {
        if ("admin".equals(username)){
            return new User("1", "admin", "254b59d286a99b5c2ff4a154db64c95b", "65555551");
        }
        return null;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }


}
