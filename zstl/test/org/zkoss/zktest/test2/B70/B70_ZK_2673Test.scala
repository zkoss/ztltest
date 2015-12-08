/* B70_ZK_2673Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 14:43:49 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2673.zul")
class B70_ZK_2673Test extends ZTL4ScalaTestCase {
  @Test
	def testCase() = {
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B70-ZK-2673.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Mon Jun  8 18:38:29 CST 2015, Created by chunfu
			|
			|Copyright (C)  Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk>
			|	<label multiline="true">
			|	1. Hover on question icon, should see nav popup showed.
			|	2. open the following nav until Nav4
			|	3. open Nav4, you should see the width of popup adjusted
			|	</label>
			|	<zscript>
			|	void addItem(boolean open, Nav nav) {
			|		if (open) {
			|			Navitem item = new Navitem();
			|			item.setLabel("Looooooooooooooooooooong label");
			|			item.setIconSclass("z-icon-circle");
			|			nav.appendChild(item);
			|		}
			|	}
			|	</zscript>
			|	<navbar orient="vertical" width="45px" collapsed="true">
			|		<nav iconSclass="z-icon-question-circle" label="Nav 1">
			|			<nav iconSclass="z-icon-question-circle" label="Nav 2">
			|				<nav iconSclass="z-icon-question-circle" label="Nav 3">
			|					<nav iconSclass="z-icon-question-circle" label="Nav 4"
			|						onOpen="addItem(event.isOpen(), self)">
			|					</nav>
			|				</nav>
			|			</nav>
			|		</nav>
			|	</navbar>
			|</zk>
			|
		""".stripMargin
		}

		runZTL(zscript, () => {
			var nav = jq(".z-nav-content")
			mouseOver(nav)
			waitResponse()
			var navpp = jq(".z-nav-popup .z-nav-content")
			click(navpp.eq(0))
			waitResponse()
			click(navpp.eq(1))
			waitResponse()
			var origWidth = jq(".z-nav-popup").width();
			click(navpp.eq(2))
			waitResponse()
			verifyNotEquals(origWidth, jq(".z-nav-popup").width())
			verifyTrue(jq(".z-nav-popup").width() > origWidth)
			println(origWidth, jq(".z-nav-popup").width())
		})
	}
}
