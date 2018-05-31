/* B80_ZK_3221Test.scala

	Purpose:

	Description:

	History:
		Mon, Sep 26, 2016  5:22:22 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3221Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val item = jq(".z-listitem")
      mouseDownAt(item, "5,5")
      mouseMoveAt(item, "20,20")
      verifyContains(jq("#zk_ddghost").text, "123456789123456789")
    })
  }
}
