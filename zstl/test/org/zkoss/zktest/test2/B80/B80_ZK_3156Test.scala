/* B80_ZK_3156Test.scala

	Purpose:

	Description:

	History:
		Thu, Sep 29, 2016 11:19:15 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers;

/**
  *
  * @author Sefi
  */
@IgnoreBrowsers("chrome,ff,safari,ie11,ie10,ie9")
class B80_ZK_3156Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      verifyEquals("true", getEval("jq(\".z-label:eq(1)\").text().length > 6"))
    })
  }
}
