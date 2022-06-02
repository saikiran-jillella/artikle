package com.saikiran.artikle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtikleApplication {

//    @Autowired
//    private IUserHandler userHandler;
//    @Autowired
//    private IArticleFetcher articleFetcher;
//
//    private static ApplicationContext applicationContext;
//
//
//    public static final Logger log = LoggerFactory.getLogger(ArtikleApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ArtikleApplication.class, args);
    }
//
//    public static ApplicationContext getAppContext(){
//        return applicationContext;
//    }
//
//    public static void randomMethod(){
//        IUserHandler userhandler = ArtikleApplication.getAppContext().getBean(UserHandler.class);
//        log.info("{}",userhandler.getUsers().toString());
//
//    }
}
