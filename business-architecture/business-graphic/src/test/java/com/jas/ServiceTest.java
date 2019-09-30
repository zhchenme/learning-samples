package com.jas;

import com.jas.constant.BusinessScenarioEnum;
import com.jas.constant.IndustryEnum;
import com.jas.facade.ICustomFacade;
import com.jas.facade.service.CustomService;
import com.jas.request.CommonRequest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ServiceTest
 *
 * @author lanxiang
 * @since 2019-09-29
 */
public class ServiceTest {

    private static final String RESOURCE_PATH = "classpath:applicationContext.xml";

    @Test
    public void getTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(RESOURCE_PATH);
        ICustomFacade customService = applicationContext.getBean(CustomService.class);
        CommonRequest request = new CommonRequest();
        request.setBusinessScenario(IndustryEnum.INDUSTRY_ONE.getType());
        request.setIndustry(BusinessScenarioEnum.BUSINESS_SCENARIO_ONE.getType());
        System.out.println(customService.getTest(request));
    }

    @Test
    public void insertTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(RESOURCE_PATH);
        ICustomFacade customService = applicationContext.getBean(CustomService.class);
        CommonRequest request = new CommonRequest();
        request.setBusinessScenario(IndustryEnum.INDUSTRY_TWO.getType());
        request.setIndustry(BusinessScenarioEnum.BUSINESS_SCENARIO_TWO.getType());
        System.out.println(customService.insertTest(request));
    }

    @Test
    public void complexTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(RESOURCE_PATH);
        ICustomFacade customService = applicationContext.getBean(CustomService.class);
        CommonRequest request = new CommonRequest();
        request.setBusinessScenario(BusinessScenarioEnum.BUSINESS_SCENARIO_TWO.getType());
        request.setIndustry(IndustryEnum.INDUSTRY_ONE.getType());
        System.out.println(customService.complexTest(request));
    }

}
