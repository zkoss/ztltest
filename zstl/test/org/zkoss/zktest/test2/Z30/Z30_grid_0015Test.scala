/* Z30_grid_0015Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 12:56:21 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug grid-0015
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z30-grid-0015.zul,Z30,A,E,Grid,Paging")
class Z30_grid_0015Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {

    runZTL(() => {
        verifyRowContent("$grid1", Iterator(
          "Item 1.1",
          "Item 2.1",
          "Item 3.1",
          "Item 4.1"
        ));

        verifyRowContent("$grid2", Iterator(
          "Item A.1",
          "Item B.1",
          "Item C.1",
          "Item D.1"
        ));
        //"[name=" + jq(".z-paging").attr("id") + "-next]" (when using IR getting wrong, need to survey) 
        clickThenValidate(".z-paging-next", () => {
          verifyRowContent("$grid1", Iterator(
            "Item 5.1",
            "Item 6.1",
            "Item 7.1"
          ));

          verifyRowContent("$grid2", Iterator(
            "Item E.1",
            "Item F.1"
          ));
        });

        //"[name=" + jq(".z-paging").attr("id") + "-prev]"
        clickThenValidate(".z-paging-previous", () => {
          verifyRowContent("$grid1", Iterator(
            "Item 1.1",
            "Item 2.1",
            "Item 3.1",
            "Item 4.1"
          ));

          verifyRowContent("$grid2", Iterator(
            "Item A.1",
            "Item B.1",
            "Item C.1",
            "Item D.1"
          ));

        });
      }
    );
    def clickThenValidate(selector: String, validator: () => Unit) {
      click(jq(selector));
      waitResponse()
      validator()
    }

    def verifyRowContent(gridSelector: String, iterator: Iterator[String]) = {
      var rows = jq(gridSelector).find(".z-row")
      var index = 0
      while (iterator.hasNext) {
        val row = rows.eq(index)
        var text = iterator.next()
        verifyEquals(row.find(".z-label:first").text(), text);
        index += 1
      }
    }
  }
}