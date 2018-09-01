/* B36_2827671Test.java

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


class B36_2827671Test extends ZTL4ScalaTestCase {
  @Test
  def testerror() = {
    var zscript =
      """
			<?page title="B36-2827671" contentType="text/html;charset=UTF-8"?>
			<zk>
			<window title="FieldComparator Seriailzation Test" border="normal">
			<html><![CDATA[
			<ol>
			<li>Press the "Click Me and see any exception"</li>
			<li>If pop out "OK", then it is OK.</li>
			<li>If pop out "Bug: ...Exception", then there is BUG.</li>
			</ol>
				]]>
			</html>
			<button label="Click Me and see any exception">
			<attribute name="onClick">
			<![CDATA[
			{
				import java.io.ByteArrayInputStream;
				import java.io.ByteArrayOutputStream;
				import java.io.ObjectOutputStream;
				import java.io.ObjectInputStream;
				
					FieldComparator fcOld;
					FieldComparator fcNew;
			
					fcOld = new FieldComparator("TestColumn", false);
			
					// Serialize the original class object
					ByteArrayOutputStream fo = new ByteArrayOutputStream();
					try {
						ObjectOutputStream so = new ObjectOutputStream(fo);
						so.writeObject(fcOld);
						so.flush();
						so.close();
					} catch (Exception ex) {
						alert("Bug: "+ex);
					}
			
					// Deserialize in to new class object
					ByteArrayInputStream fi = new ByteArrayInputStream(fo.toByteArray());
					try {
						ObjectInputStream si = new ObjectInputStream(fi);
						fcNew = (FieldComparator) si.readObject();
						si.close();
						alert("OK");
					} catch (Exceptino ex) {
						alert("Bug: "+ex);
					}
			}
			]]>
			</attribute>
			</button>
			</window>
			</zk>
		 """
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("OK", getText(jq("@label")))
      click(jq("$btn1"))
    })
  }
}



