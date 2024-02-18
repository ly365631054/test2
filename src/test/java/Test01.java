import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author yong.li_1
 **/
public class Test01 {

    @Test
    public void test() {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("liyong", "123456");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("liyong", "123456"));
        System.out.println(subject.isAuthenticated());

        subject.logout();

        System.out.println(subject.isAuthenticated());
    }
}
