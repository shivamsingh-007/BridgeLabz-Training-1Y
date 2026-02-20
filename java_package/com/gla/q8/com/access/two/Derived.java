package com.access.two;

import com.access.one.Base;

public class Derived extends Base {

    public void testAccess() {
        publicMethod();
        protectedMethod();
        callPrivate();
    }
}
