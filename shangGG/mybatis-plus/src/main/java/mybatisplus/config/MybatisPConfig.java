package mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//可将包扫描写在这个类里面 也可以写在启动类上，对持久层的扫描
@Configuration//表示这是一个配置类，应用程序启动的时候会被自动读取并以配置的形式读取
@MapperScan("mybatisplus.mapper")//可以将持久层所有的配置集中在这里管理 全写在这个配置类中
public class MybatisPConfig {
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    //所有的插件都是以拦截器的形式存在
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //先创建拦截器（插件）管理器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加分页插件 将分页（这里是mysql）添加到一个内置的拦截器管理器中（ 将分页插件的拦截器对象创建出来，然后用此方法配置到 这个管理器之中）
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //添加乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //最后将这个interceptor对象，作为一个bean对象返回
        return interceptor;
    }

//    @Bean
//    public ConfigurationCustomizer configurationCustomizer() {
//        return configuration -> configuration.setUseDeprecatedExecutor(false);
//    }
}

