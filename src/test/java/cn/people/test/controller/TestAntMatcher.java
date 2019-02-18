package cn.people.test.controller;

    
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
     
    public class TestAntMatcher {
        @Test
        public void testMatch() {
            PathMatcher matcher = new AntPathMatcher();
     
            System.out.println(matcher.match("/user/*", "/user/add"));
            System.out.println(matcher.match("/user/**/update", "/user/1/update"));
            System.out.println(matcher.match("/user/**/update", "/user/add"));
    }

}
