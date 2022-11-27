package mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    //告诉mp这 就是版本号
    @Version
    private Integer version;

}
