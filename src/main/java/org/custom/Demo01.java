package org.custom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

/**
 * @Author yong.li_1
 **/
public class Demo01 {

    @Test
    public void auth(){

        CustomRealm customRealm = new CustomRealm();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        securityManager.setRealm(customRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("admin", "admin"));

        System.out.println(subject.isAuthenticated());

        System.out.println("第三次提交");



//                System.out.println(new Md5Hash("admin", "65555551", 1024));
    }
}
