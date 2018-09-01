/* B50_3296607Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3296607Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<zk xmlns:w="client">
	<script type="text/javascript">
		function setText(txt, id) {
			var db = zk.Widget.$(id),
				inp = db.getInputNode();
			inp.value = txt;
			jq(inp).blur();
			var index = id.charAt(3),
				res = (index == '4' || index == '5') ? db.getErrorMesssage() ? 'O': 'X': db.getErrorMesssage() ? 'X' : 'O';
			jq(db.previousSibling.previousSibling).html(res).css('background-color', res == 'O' ? 'blue': 'red').css('color',  'white');
		}
	</script>
	<button label="click me, then check wether pass.">
		<attribute w:name="onClick"><![CDATA[
			setText('16-02-1998', '$db0');
			setText('16-Mar-1998', '$db1');
			setText('16-09-1998', '$db2');
			setText('189', '$db3');
			setText('1890', '$db4');
			setText('18999', '$db5');
			setText('18', '$db6');
		]]></attribute>
	</button>
	<grid width="300px">
		<columns>
			<column width="30px"/>
			<column width="120px"/>
			<column/>
		</columns>
		<rows>
			<row forEach="16-02-1998,16-Mar-1998,16-09-1998,189,1890,18999,18">
				<div/>
				<label value="${each}"/>
				<datebox id="db${forEachStatus.index}" format="dd-MMM-yyyy" width="100px" locale="en_US"/>
			</row>
		</rows>
	</grid>
</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals(2, jq(".z-errorbox").length())
      for (i <- 0 until 6) {
        verifyEquals("O", jq("@row:eq(" + i + ") td.z-row-inner:eq(0)").text())
      }
    }
    )
  }
}



