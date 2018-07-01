/* B30_1892484Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1892484
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1892484.zul,A,E,Tree,Serialize,BI")
class B30_1892484Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        //Click 'serialize tree'
        click(jq("@button:eq(2)"))
        waitResponse()

        //Check 2 trees
        verifyTrue(jq(".z-tree:eq(0)").isVisible())
        verifyTrue(jq(".z-tree:eq(1)").isVisible())

        //Click 'replace'
        click(jq("@button:eq(0)"))
        waitResponse()

        var j1 = jq(".z-tree:eq(0) .z-treecell:eq(2)")
        var j2 = jq(".z-tree:eq(1) .z-treecell:eq(2)")
        val txt1 = getText(j1)
        val txt2 = getText(j2)

        val l2 = "Matter"
        val l1 = "[Clinton, Obama]"

        //Tree 1 is modified
        verifyContains(txt1, l1)

        //Tree 2 not modified
        verifyContains(txt2, l2)

        //Click 'replace 2'
        click(jq("@button:eq(1)"))
        waitResponse()

        val j21 = jq(".z-tree:eq(0) .z-treecell:eq(2)")
        val j22 = jq(".z-tree:eq(1) .z-treecell:eq(2)")

        //Tree 1 is not modified
        val txt21 = getText(j21)
        verifyContains(txt21, l1)

        //Tree 2 is modified
        val txt22 = getText(j22)
        verifyContains(txt22, l1)


      }
    )
  }
}
