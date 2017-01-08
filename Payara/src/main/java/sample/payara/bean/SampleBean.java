package sample.payara.bean;

import sample.payara.model.SampleModel;

import javax.ejb.Stateless;

@Stateless
public class SampleBean {

    public SampleModel findOne() {
        return new SampleModel();
    }

}
