package com.itheima.log;

import com.itheima.bean.Log;
import com.itheima.bean.User;
import com.itheima.dao.LogDao;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LogAspect {
    public LogAspect() {
        System.out.println("logAspect创建了");
        System.out.println(logDao);
    }

    @Autowired
    private LogDao logDao;

    public void logAspect(JoinPoint joinPoint, User user) {
        System.out.println("logAspect方法执行");
        Log log = new Log();
        User args = (User) joinPoint.getArgs()[0];
        String username = args.getUsername();
        log.setUsername(username);
        log.setTime(new Date());
        if (user == null) {
            log.setStatus("N");
        } else {
            log.setStatus("Y");
        }
        System.out.println("log............................................");
        logDao.addLog(log);
    }
}
