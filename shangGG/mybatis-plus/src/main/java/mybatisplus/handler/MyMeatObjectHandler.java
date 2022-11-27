package mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
//实现MetaObjectHandler 专门用于填充功能
@Component //spring自动管理 程序启动的时候会去检查是否有自动填充的注解 然后进行实现(fill =FieldFill.**）
public class MyMeatObjectHandler implements MetaObjectHandler {
    //实现填充业务逻辑 元数据对象
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert自动填充....");
        //插入数据的时候 识别到注解  @TableField(fill = FieldFill.INSERT) 就会进入这个方法来执行
        //元数据对象（包含的当前列名，类型之类的具体信息） | 属性名  | 填充的数据的类型  |  填充的具体内容
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        log.info("age 填充为18");
        //如果业务层赋值了就不用去填充，如果没有赋值去进行填充 从元数据中去取 age这个属性，判断其是否有值
        Object age = this.getFieldValByName("age", metaObject);
        if (age == null) {
            this.strictInsertFill(metaObject, "age", Integer.class, 18);
        }
        //假设另外的表、实体类 有author 属性 在对user数据对象进行数据填充的时候，会执行代码，所以需要进行判断识别是否执行填充操作
        //判断当前对象自动填充属性是否包含 当前属性 并且有setter方法可以进行赋值
        boolean hasAuthor = metaObject.hasSetter("author");
        //如果 有setter的方法 有这个author字段 进行自动填充author
        if (hasAuthor) {
            log.info("insert author属性");
            this.strictInsertFill(metaObject, "author", String.class, "石头");
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update自动填充。。。");
        //更新的时候
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

}
