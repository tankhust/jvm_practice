package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/02 18:52
 */
public class MyPerson {
    MyPerson myPerson;

    public void setMyPerson(Object person) {//为了使method能够调用invoke方法，否则删掉Myperson.class后就不能执行invoke方法了，详见MyTest21
        this.myPerson = (MyPerson)person;
    }

}
