package com.xie.study.list;

import com.xie.study.pojo.Person;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class CloneList {

    public static<T>List<T> deepCopy(List<T> src) throws IOException,ClassNotFoundException{
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn= new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest=(List<T>)in.readObject();
        return dest;
    }

    //public static void main(String[] args) {
       // List<Person> destList = deepCopy(srcList);
    //}



}
