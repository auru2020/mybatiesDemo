import com.github.pagehelper.PageHelper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    @Test
    public void insertTest() throws IOException {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //sqlSession.commit();
        System.out.println("结果："+result);
    }

    @Test
    public void selectTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User result = userMapper.getUserById(1);
        System.out.println(result.toString());
    }

    @Test
    public void checkLoginTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User result = userMapper.checkLogin("admin","123457");
        System.out.println(result.toString());
    }

    @Test
    public void pageTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,4);
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(System.out::println);
    }
}
