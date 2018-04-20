package com.zpark.fm;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTextOutput {

    public static void main(String[] args) throws IOException, TemplateException {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangsan");
        User user = new User();
        user.setId(1);
        user.setName("lisi");
        map.put("user", user);
        List list = new ArrayList();
        list.add("香蕉");
        list.add("梨");
        list.add("苹果");
        map.put("list", list);

        Map city = new HashMap();
        city.put("bj", "北京");
        city.put("sh", "上海");
        city.put("us", "美国");

        map.put("citys", city);

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File("E:\\Workspaces\\SpringBoot_Freemarker\\src\\main\\resources\\template"));
        Template template = configuration.getTemplate("index.html");
        template.process(map, new FileWriter("F:\\index.html"));
    }


}
