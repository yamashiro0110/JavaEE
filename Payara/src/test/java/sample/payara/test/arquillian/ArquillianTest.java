package sample.payara.test.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import sample.payara.Application;
import sample.payara.dao.SampleModelDao;
import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.repotiroy.AppleMyBatisRepository;

import javax.inject.Inject;
import java.util.List;

@RunWith(Arquillian.class)
public class ArquillianTest {
    @Inject
    SampleModelDao sampleModelDao;
    @Inject
    AppleMyBatisRepository appleMyBatisRepository;

    @Deployment
    public static Archive<WebArchive> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ArquillianTest.war")
                .addPackages(true, Application.class.getPackage())
                .addAsResource("mybatis-config.xml")
                .addAsResource("META-INF/persistence.xml");
    }

    @Test
    public void test() {
        Assert.assertTrue(true);
    }

    @Test(expected = Exception.class)
    public void testFindAll() {
        this.sampleModelDao.findAll();
    }

    @Test
    public void testAppleMyBatisMapper() {
        List<MyBatisUser> users = this.appleMyBatisRepository.findAll();
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        users.forEach(System.out::println);
    }

}
