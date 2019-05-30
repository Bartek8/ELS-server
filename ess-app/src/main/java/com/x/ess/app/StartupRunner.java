package com.x.ess.app;


import com.x.ess.dao.User;
import com.x.ess.dao.others.UserType;
import com.x.ess.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author x
 */
@Component
public class StartupRunner implements ApplicationRunner {

    protected final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private ApplicationContext ctx;


    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
       // createDefaultAdmin();
//        createMisc();
        printBeans();
    }

    public void createDefaultAdmin() {
        User admin = userService.findByLogin("admin");
        if (admin == null) {

            admin = User.builder()
                    .name("admin")
                    .login("admin")
                    .surname("admin")
                    .userType(UserType.ADMINISTRATOR)
                    .build();

            userService.save(admin);
        }
    }



    public void printBeans() {
        String[] beansNames = ctx.getBeanDefinitionNames();

        List<String> controllers = new ArrayList<>();
        List<String> services = new ArrayList<>();
        List<String> repositories = new ArrayList<>();

        for (String bean : beansNames) {
            if (bean.contains("Controller")) {
                controllers.add(bean);
            }
            if (bean.contains("Repository") && !bean.contains(".")) {
                repositories.add(bean);
            }
            if (bean.contains("Service") && !bean.contains(".")) {
                services.add(bean);
            }
        }
        int counter = 1;
        System.out.println("\nControllers List: ");
        for (String controller : controllers) {

            System.out.println(counter + ". " + controller);
            counter++;
        }
        counter = 1;
        System.out.println("\nRepositories List: ");
        for (String repo : repositories) {

            System.out.println(counter + ". " + repo);
            counter++;
        }
        counter = 1;
        System.out.println("\nServices List: ");
        for (String service : services) {

            System.out.println(counter + ". " + service);
            counter++;
        }
        System.out.println("");
    }
}
