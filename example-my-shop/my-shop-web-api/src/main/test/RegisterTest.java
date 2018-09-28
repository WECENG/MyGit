import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.api.dao.TbUserDao;
import com.funtl.my.shop.web.api.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: werson
 * @Date: 2018/9/28/028 17:09
 * @Description:
 */
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:spring-context-mybatis.xml","classpath:spring-context-druid.xml"}) //加载配置文件
@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterTest {
    @Autowired
    TbUserDao tbUserDao;

    @Test
    public void register(){
        TbUser user=new TbUser();
        user.setPassword("123456");
        user.setUsername("user");
        user.setPhone("183163");
        tbUserDao.save(user);
    }

    @Test
    public void findTbUser(){
        System.out.println(tbUserDao.selectTbUserByUsername("werson"));
    }
}
