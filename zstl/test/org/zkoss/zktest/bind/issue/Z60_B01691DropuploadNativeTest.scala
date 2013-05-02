/* Z60_B01691DropuploadNativeTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01691DropuploadNativeTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01691DropuploadNative.zul"/>
    }

    runZTL(zul, () => {

      var lab1 = jq("$lab1")
      var lab2 = jq("$lab2")

      var btn1 = jq("$btn1")
      var btn2 = jq("$btn2")

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("true", lab1.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse()
      verifyEquals("native is true", lab2.toWidget().get("value"))

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("false", lab1.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse()
      verifyEquals("native is false", lab2.toWidget().get("value"))

    })
  }
}
