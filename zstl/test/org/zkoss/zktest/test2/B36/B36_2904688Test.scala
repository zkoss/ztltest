/* B36_2904688Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2904688Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<button label="Click Me!, you should see 'The bug is fixed!' ">
	<attribute name="onClick">{
import java.io.*;
DefaultTreeNode stn = new DefaultTreeNode(null, null);
ByteArrayOutputStream boa = new ByteArrayOutputStream();
new ObjectOutputStream(boa).writeObject(stn);
byte[] bs = boa.toByteArray();
Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
alert("The bug is fixed!");
	}</attribute>
</button>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("The bug is fixed!", getAlertMessage())
    })
  }
}



