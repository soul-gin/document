package cn.e3mall.search.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author
 * @Description
 * @create 2018-03-05 15:19
 **/
/*
    除了写GlobalExceptionResolver继承HandlerExceptionResolver
    还需要在该项目下的 springmvc.xml 中配置全局异常处理器

    <!-- 全局异常处理器 -->
	<bean class="cn.e3mall.search.exception.GlobalExceptionResolver"></bean>
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    //推荐用org.slf4j.Logger的logger
    //项目resource目录下必须有log4j.properties 并配置了 A3 的各项属性
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    /*
    # 日志的输出路径配置
    # 就是在配置了全局异常处理的项目下\logs 目录下 server.log
    # R:\Java\code\idea_workspace\e3parent\e3_search_web\logs
    log4j.appender.A3.file=logs/server.log
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //打印控制台(自测用)
        ex.printStackTrace();
        //写日志(运行时)
        //logger.debug("测试输出的日志",ex);
        logger.debug("测试输出的日志");
        //logger.info("系统发生异常 INFO",ex);
        logger.info("系统发生异常 INFO");
        logger.error("系统发生异常",ex);

        //发送邮件,发短信
        //使用jmail工具包  发短信使用第三方的WebService

        //显示错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/exception");

        return modelAndView;
    }
}
