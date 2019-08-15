package tomcat;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @author: shichao
 * @date: 2019/8/15
 * @description:
 */
public class TomcatServer {

    public static void main(String[] args)  {
        //指定目标类路径
        String classPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes";
        //创建Tomcat实例
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);
        //设置Host
        Host host = tomcat.getHost();
        host.setName("localhost");
        host.setAppBase("webApp");
        //启动Tomcat
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
