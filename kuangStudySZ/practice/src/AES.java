import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;

public class AES {
    /*AES-加密自定义初始化向量*/
    public static void main(String[] args) throws UnsupportedEncodingException{
    //秘钥key
        String key="a69b5fc15d880cae4259a5c4ca217eab";
        String toSignStr="appno=1a00112a123456ss&timestamp=20210722215402";
        byte[] toSignStrByte=new byte[0];
        System.out.println("这个空字节数组长度："+toSignStrByte.length);

        try {
            toSignStrByte=toSignStr.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("将需要加密的内容转换成字节数组放进去后的长度："+toSignStrByte.length);
        System.out.println("待加密内容--->"+new String(toSignStrByte, "utf-8"));
        System.out.println("秘钥--->"+key);
        //定义初始向量
        //以秘钥前面16位为初始向量
        String ivString=key.substring(0,16);
        System.out.println("初始向量"+ivString);
        System.out.println("初始向量的长度--->"+ivString.getBytes().length);

        try {
        //初始化秘钥对象
        //将秘钥转换为字节数组
        byte[] keyBytes=key.getBytes("utf-8");
        System.out.println("秘钥初始化后的字节数组："+ Arrays.toString(keyBytes));
        if(ivString.length()!=16){
            System.out.println("向量的长度不是16位");
        }

        //初始化初始向量，不传入的话，则默认用全0的初始化向量
        //将初始向量转化为utf-8格式的字节数组
        byte[] initParm= ivString.getBytes("utf-8");
        System.out.println("向量的bytes[]==>"+Arrays.toString(initParm));
        IvParameterSpec ivSpec= new IvParameterSpec(initParm);

        //指定加密的算法  工作模式和填充模式 需求要的事PKCS7
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(keyBytes,"AES"),ivSpec);
        System.out.println(Arrays.toString(toSignStrByte));

        byte[] encryptedBytes= cipher.doFinal(toSignStrByte);
        String encodedString =new String(Base64.getEncoder().encode(encryptedBytes),"utf-8");
            System.out.println("加密后的结果=="+encodedString);
            System.out.println("测试结果是否正确：=="+encodedString.equals("GBO0eNVxy9oyu/+PYBmfPo5kg+nvHMGpddTsluCCyxBzjp67U2X53Ko9UBSxrKOs"));

        }catch (Exception ex){
            ex.printStackTrace();
        }
        //用hashMap存储
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("appNo","a55f440c25ec45c594ba001eab56d793");
        hashMap.put("timestamp","20210730153029");
        hashMap.put("sign","123dsf5");
        hashMap.put("Content-Type","application/json");
        System.out.println(hashMap);

    }

    }

