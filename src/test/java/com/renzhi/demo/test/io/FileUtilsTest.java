package com.renzhi.demo.test.io;

import cn.hutool.Hutool;
import com.renzhi.demo.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Set;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Slf4j
public class FileUtilsTest extends BaseTest {

    @Test
    public void copyToString() throws Exception {
        FileCopyUtils.copyToString(new InputStreamReader(new FileInputStream(new File("")),"utf-8"));
    }

    @Test
    public void readFileToString() throws IOException {
        String s = FileUtils.readFileToString(new File("", "utf-8"));
    }

}
