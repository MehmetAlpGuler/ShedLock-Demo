package com.jzwzz.jobdemo.jobdemo.job;

import org.junit.Test;

public class DemoJobTest {

    @Test
    public void increase1() throws InterruptedException {
        DemoJob job = new DemoJob();
        String s = job.increase("", 0);
        System.out.println("s = " + s);
        assert s.equals("1");
    }

    @Test
    public void increase2() throws InterruptedException {
        DemoJob job = new DemoJob();
        String s = job.increase(null, 0);
        System.out.println("s = " + s);
        assert s.equals("1");
    }

    @Test
    public void increase3() throws InterruptedException {
        DemoJob job = new DemoJob();
        String s = job.increase("0", 0);
        System.out.println("s = " + s);
        assert s.equals("1");
    }
}