package org.qifei.springframework.beans;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/29 11:13
 * @Description
 */
public class BeanFactoryTest {
    private boolean flag;
    private Boolean flag1;

    @Test
    public void getBeanTest() {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("BeanConfiguration.xml"));
        QifeiTestBean myTestBean = (QifeiTestBean)factory.getBean("myTestBean");
        assertEquals("超级无敌大帅哥", myTestBean.getName());

    }

    @Test
    public void test1() {
        System.out.println(this.flag);
        System.out.println(this.flag1);

    }

    @ParameterizedTest
    @ValueSource(strings = { "dtdWithTrailingComment.xml", "dtdWithLeadingComment.xml", "dtdWithCommentOnNextLine.xml",
            "dtdWithMultipleComments.xml" })
    public void test(String fileName) {
//        XmlValidationModeDetector xmlValidationModeDetector = new XmlValidationModeDetector();
//        InputStream inputStream = getClass().getResourceAsStream(fileName);
//        assertThat(xmlValidationModeDetector.detectValidationMode(inputStream)).isEqualTo(VALIDATION_DTD);

    }
}
