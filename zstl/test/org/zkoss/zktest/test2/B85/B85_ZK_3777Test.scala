/* B85_ZK_3777Test.scala

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
class B85_ZK_3777Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      dragdropTo(jq(".z-slider-button"), "5,5", "5,100")
      waitResponse();
      verifyContains("Zklog should contain 'Test'.", getZKLog(), "Test")
    })
  }
}
