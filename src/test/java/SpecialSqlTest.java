import mapper.SpecialSqlMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.util.List;

public class SpecialSqlTest {
    @Test
    public void mohuTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //通过代理模式创建UserMapper接口的代理实现类对象
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> result = mapper.selectUserByName("%l%");
        result.forEach(System.out::println);
    }
}
