/* F85_ZK_3658Test.java

        Purpose:

        Description:

        History:
                Tue May 22 17:47:47 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.JQuery

class F85_ZK_3658Test extends ZTL4ScalaTestCase {

    @Test
    def test(): Unit = {
        runZTL(() => {
            testTextbox(jq(".z-textbox"))
            click(jq(".z-button"))
            waitResponse()
            testTextbox(jq(".z-textbox"))
        })
    }

    def testTextbox(textbox: JQuery): Unit = {
        typeTextbox(textbox, "add")
        typeTextbox(textbox, "remove")
    }

    def typeTextbox(textbox: JQuery, str: String): Unit = {
        keyPress(textbox, str)
        waitResponse()
        verifyEquals(str, textbox.`val`())

        findElement(textbox.toBy).clear()
        waitResponse()
    }
}
