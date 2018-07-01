/* B85_ZK_3604Test.scala

	Purpose:

	Description:

	History:
		Wed, Nov 1, 2017 12:33:17 PM, Created by bobpeng

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3604Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var toggleBtn = jq(".z-button").get(0)
      var wListhead = jq(".z-listheader:eq(0)").width()
      var wListcell = jq(".z-listitem .z-listcell:first-child:eq(0)").width()
      var wGroupListcell = jq(".z-listitem .z-listcell:first-child:eq(1)").width()
      println(wListhead, wListcell, wGroupListcell)

      click(toggleBtn)
      waitResponse()
      verify(Array(0, 0, 0): _*)

      click(toggleBtn)
      waitResponse()
      verify(Array(wListhead, wListcell, wGroupListcell): _*)

    })
  }

  def verify(some: Int*) = {
    println(some)
    verifyEquals(some(0), jq(".z-listheader:eq(0)").width())
    verifyEquals(some(1), jq(".z-listitem .z-listcell:first-child:eq(0)").width())
    verifyEquals(some(2), jq(".z-listitem .z-listcell:first-child:eq(1)").width())
    verifyFalse(jq(".z-listgroup.z-listgroup-open").exists())
  }
}
