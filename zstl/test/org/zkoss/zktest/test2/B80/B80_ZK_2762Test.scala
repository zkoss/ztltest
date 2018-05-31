/* B80_ZK_2762Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B80_ZK_2762Test extends ZTL4ScalaTestCase {
  @Test
  def testtitle() = {
    runZTL(() => {
      verifyEquals("someobject", jq("title").html())
    })
  }
}



