/* Z30_grid_0006Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 11:54:15 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.util.Scripts

/**
  * A test class for bug grid-0006
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z30-grid-0006.zul,Z30,B,E,Grid,Sorting")
class Z30_grid_0006Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        verifyTolerant(jq("$col").outerWidth(), 125, 5);

        click(jq("$btnWid"))
        waitResponse()
        sleep(1000)
        verifyNotEquals(String.valueOf(jq("$col").outerWidth()), "125");
        verifyEquals(String.valueOf(jq("$col").outerWidth()), "200");


        clickAt(jq("$col"), "2,2")
        waitResponse()


        def verifyRowContent(iterator: Iterator[String]) = {
          var rows = jq("@row")
          var index = 0
          while (iterator.hasNext) {
            val row = rows.eq(index)
            verifyEquals(row.find(".z-label:first").text(), iterator.next());
            index += 1
          }
        }

        verifyRowContent(Iterator("A31", "Apple", "Lemon", "Orange", "Tomato"));

        click(jq("$addRow"))
        waitResponse()
        verifyRowContent(Iterator("A31", "Apple", "Lemon", "Orange", "Tomato", "A31"));

        click(jq("$insRow"))
        waitResponse()
        verifyRowContent(Iterator("Ins1", "A31", "Apple", "Lemon", "Orange", "Tomato", "A31"));

        clickAt(jq("$col"), "2,2")
        waitResponse()
        verifyRowContent(Iterator("Tomato", "Orange", "Lemon", "Ins1", "Apple", "A31", "A31"));

        clickAt(jq("$col"), "2,2")

        waitResponse()
        verifyRowContent(Iterator("A31", "A31", "Apple", "Ins1", "Lemon", "Orange", "Tomato"));
      }
    );
  }
}