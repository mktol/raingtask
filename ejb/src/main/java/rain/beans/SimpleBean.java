package rain.beans;

import common.Common;

import javax.ejb.Stateless;

@Stateless(name = "SimpleEJB")
public class SimpleBean {

    public SimpleBean() {
    }

    public String sayHello() {
        Common common = new Common();
        return "EJB says hey. Vis EJB: "+common.sayHello();
    }


}
