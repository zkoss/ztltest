/* B80_ZK_2461Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Oct 27 10:13:02 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B80-ZK-2461.zul")
class B80_ZK_2461Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B80-ZK-2461.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Tue Oct 27 09:09:27 CST 2015, Created by chunfu
			|
			|Copyright (C)  2015 Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk xmlns:w="client">
			|	<label multiline="true">
			|		1. click "add Listheader to end" in IE8
			|		2. each listheader should occupy one third of the width (not one fourth)
			|	</label>
			|	<script>
			|		zk.afterMount(function() {
			|			jq('.z-listheader').each(function () {
			|				zk.log(jq(this).width());
			|			})
			|		});
			|	</script>
			|	<listbox id="list" width="250px">
			|		<listhead sizable="true">
			|			<listheader label="name" />
			|			<listheader label="gender" sort="auto"/>
			|		</listhead>
			|		<listitem>
			|			<listcell label="Mary" />
			|			<listcell label="FEMALE" />
			|		</listitem>
			|		<listitem>
			|			<listcell label="John" />
			|			<listcell label="MALE" />
			|		</listitem>
			|		<listitem>
			|			<listcell label="Jane" />
			|			<listcell label="FEMALE" />
			|		</listitem>
			|		<listitem>
			|			<listcell label="Henry" />
			|			<listcell label="MALE" />
			|		</listitem>
			|		<listfoot>
			|			<listfooter label="Footer1"/>
			|			<listfooter label="Footer2"/>
			|		</listfoot>
			|	</listbox>
			|	<button label="add Listheader to end">
			|		<attribute name="onClick">
			|			new Listheader("Test").setParent(list.getListhead());
			|			List rows = list.getItems();
			|			for (Iterator it = rows.iterator(); it.hasNext();) {
			|			Listitem row = it.next();
			|			new Listcell("test").setParent(row);
			|			}
			|		</attribute>
			|	</button>
			|	<button label="print width" w:onClick="jq('.z-listheader').each(function () { zk.log(jq(this).width())} )" />
			|</zk>
		""".stripMargin
		}

		runZTL(zscript, () => {
			var initWidth = 0
			for (w <- getZKLog.split('\n')) initWidth += w.toInt
			click(jq("@button"))
			waitResponse()
			click(jq("@button").eq(1))
			waitResponse()
			var afterWidth = 0
			for (w <- getZKLog.split('\n')) afterWidth += w.toInt
			println("************", initWidth, afterWidth)
			verifyTolerant(initWidth, afterWidth - initWidth, 2)
		})
	}
}
