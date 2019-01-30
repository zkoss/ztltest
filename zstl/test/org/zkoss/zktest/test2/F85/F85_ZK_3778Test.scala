/* F85_ZK_3778Test.scala

	Purpose:

	Description:

	History:
		Wed, Nov 1, 2017 12:33:17 PM, Created by bobpeng

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author bobpeng
  */
class F85_ZK_3778Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      dragdropTo(jq(".z-slider-button:eq(0)"), "1,1", "1,100")
      waitResponse();
      dragdropTo(jq(".z-slider-button:eq(1)"), "1,1", "1,100")
      waitResponse();
      verifyEquals("false\ntrue", getZKLog())
    })
  }
}
