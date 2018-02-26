package com.biz.std.test;

import com.biz.std.util.OSSClientUtil;
import org.junit.Test;

public class OSSClientUtilTest {
    @Test
    public  void  testOSS(){
        OSSClientUtil ossClientUtil=new OSSClientUtil();
        String url=ossClientUtil.getImgUrl("s2.png");
        System.out.println(url);
    }
}
