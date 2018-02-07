/* B50_ZK_620Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 14:09:58 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
  * A test class for bug ZK-620
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-620.zul,A,E,onSize,VisionTest")
class B50_ZK_620Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      click(jq("$tab"))
      waitResponse()
      var areas = Array(jq("@north"), jq("@center"))
      var windows = jq("@window")
      for (i <- 0 to 1) {
        var areaCave = areas(i).eq(0).toWidget.$n("cave")
        var areaHeight = jq(areaCave).outerHeight()
        var areaPaddings = Integer.parseInt(jq(areaCave).css("padding-top").replaceAll("px", "")) + Integer.parseInt(jq(areaCave).css("padding-bottom").replaceAll("px", ""))
        var wh = jq(windows.eq(i)).outerHeight(true)
        println("north height minue padding (" + (areaHeight - areaPaddings) + ") should equal to window height (" + wh + ")")
        verifyTolerant((areaHeight - areaPaddings), wh, 2);
      }
    })
  }
}