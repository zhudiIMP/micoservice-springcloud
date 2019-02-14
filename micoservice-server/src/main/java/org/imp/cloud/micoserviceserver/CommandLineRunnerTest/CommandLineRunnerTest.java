package org.imp.cloud.micoserviceserver.CommandLineRunnerTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//他们的执行时机为容器启动完成的时候
@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override

    public void run(String... args) throws Exception {

        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");

    }
}
