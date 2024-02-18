package org.simple;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/**
 * @Author yong.li_1
 **/
public class Demo01 {
    public static void main(String[] args) {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("liyong", "123456");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("liyong", "123456");
        usernamePasswordToken.setRememberMe(true);
        System.out.println(usernamePasswordToken);
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());

        subject.logout();

        System.out.println(subject.isAuthenticated());
    }
}
