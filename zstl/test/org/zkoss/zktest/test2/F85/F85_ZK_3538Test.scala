/* F85_ZK_3538Test.java

        Purpose:

        Description:

        History:
                Tue May 22 12:12:06 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, NonConcurrent}

// testcafe firefox's focus check will fail but it focused, move to zats solved the problem
@IgnoreBrowsers("ff")
@NonConcurrent
class F85_ZK_3538Test extends ZTL4ScalaTestCase {
    @Test
    def test(): Unit = {
        runZTL(() => {
            val textbox = jq(".z-textbox")
            typeKeys(textbox, "ch")
            waitResponse(true)
            verifyTrue(textbox.is(":focus"))
            click(jq(".z-tree-icon:eq(1)"))
            waitResponse(true)
            verifyEquals("tree is on focus", getZKLog())
        })
    }
}
