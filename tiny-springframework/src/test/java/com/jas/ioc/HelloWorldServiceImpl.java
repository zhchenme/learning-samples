package com.jas.ioc;
/**
 * HelloWorldServiceImpl
 *
 * @author lanxiang
 * @since 2019-07-29
 */
public class HelloWorldServiceImpl implements HelloWorldService{

    private String text;

    private OutputService outputService;

    @Override
    public void helloWorld(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
