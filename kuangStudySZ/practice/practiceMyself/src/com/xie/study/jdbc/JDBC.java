package com.xie.study.jdbc;

import org.junit.Test;


import java.sql.*;
import java.util.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        //获取连接
        String driver = "com.mysql.cj.jdbc.Driver";//数据库驱动类所对应的字符串
        String URL = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(URL, "root", "123123");

        String sql = "select count(*) total from TABLE_NAME where id=10";
        String sql2 = "select name,age from TABLE_NAME where id=10";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalNum = 0;
        int knowNum= 0;
        Map result[] = new Map[20];
        try {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                totalNum = rs.getInt("total");
            }
            //得到符合条件的总条数
            System.out.println(totalNum);
            //根据总条数和 页码 得到起始位置及显示条数
            if (totalNum > 0) {
                rs = ps.executeQuery(sql2);
                rs.last();
                knowNum=rs.getRow();
                rs.first();
                while(rs.next()){
                    for (int i = 0; i < knowNum; i++) {
                        Map map = new HashMap<>();
                        map.put("id", rs.getString("id"));
                        map.put("name", rs.getString("name"));
                        map.put("account", rs.getString("age"));
                        map.put("adress", rs.getString("adress"));
                        map.put("idcard", rs.getString("idcard"));
                        result[i] = map;
                    }
                }
            } else {
                result = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        }


        @Test
        public void method () {
            List<Map<String, String>> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Map map = new HashMap<>();
                map.put("id", "1");
                map.put("name", "name");
                map.put("account", "account");
                map.put("adress", "adress");
                map.put("idcard", "idcard");
                list.add(map);

            }

            System.out.println(list);
            System.out.println(list.get(0).get("idcard"));

        }
        @Test
        public void test () {
            Map arr[] = new Map[20];
            for (int i = 0; i < 2; i++) {
                Map map = new HashMap<>();
                map.put("id", "1");
                map.put("name", "name");
                map.put("account", "account");
                map.put("adress", "adress");
                map.put("idcard", "idcard");
                arr[i] = map;
            }
            System.out.println(Arrays.toString(arr));

            System.out.println(arr[0].get("idcard"));
            System.out.println(arr[1].get("name"));
            Map result[] = new Map[20];
            result=null;
            System.out.println(Arrays.toString(result));


        }


    }



