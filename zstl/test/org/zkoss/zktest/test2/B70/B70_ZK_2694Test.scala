/* B70_ZK_2694Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct 15 09:47:41 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2694.zul")
class B70_ZK_2694Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B70-ZK-2694.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Tue Jun  9 09:26:34 CST 2015, Created by jumperchen
			|
			|Copyright (C)  Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk>
			|	<custom-attributes org.zkoss.zul.nativebar="false"/>
			|	<borderlayout height="400px" width="600px">
			|		<west size="150px">
			|		<label multiline="true">
			|		1. Please click the first "div toggle tree on click"
			|		2. Open tree item "1", "1.1", "2" and then close "1"
			|		3. Open tree item "2.1" and then open "1"
			|		4. You should see a scrollbar appears
			|		</label>
			|		</west>
			|		<center autoscroll="true" id="center">
			|			<grid id="grid">
			|				<rows>
			|					<row>
			|						<cell>
			|							<div onClick="inc1.setVisible(!inc1.isVisible())">div toggle tree on click</div>
			|							<include src="test2/B70-ZK-2694_1.zul" id="inc1" visible="false"/>
			|						</cell>
			|					</row>
			|					<row>
			|						<cell>
			|							<div onClick="inc2.setVisible(!inc2.isVisible())">div toggle tree on click</div>
			|							<include src="test2/B70-ZK-2694_1.zul" id="inc2" visible="false"/>
			|						</cell>
			|					</row>
			|					<row>
			|						<cell>
			|							<div onClick="inc3.setVisible(!inc3.isVisible())">div toggle tree on click</div>
			|							<include src="test2/B70-ZK-2694_1.zul" id="inc3" visible="false"/>
			|						</cell>
			|					</row>
			|				</rows>
			|			</grid>
			|		</center>
			|		<east size="150px">
			|		</east>
			|	</borderlayout>
			|
			|</zk>
			|
		""".stripMargin
		}

		runZTL(zscript, () => {
			click(jq("@div"))
			waitResponse()
			click(jq(".z-treecell :contains(\"1\")").find(".z-tree-icon"))
			waitResponse()
			click(jq(".z-treecell :contains(\"1.1\")").find(".z-tree-icon"))
			waitResponse()
			click(jq(".z-treecell :contains(\"2\")").find(".z-tree-icon").last())
			waitResponse()
			click(jq(".z-treecell :contains(\"1\")").find(".z-tree-icon"))
			waitResponse()
			click(jq(".z-treecell :contains(\"2.1\")").find(".z-tree-icon"))
			waitResponse()
			click(jq(".z-treecell :contains(\"1\")").find(".z-tree-icon"))
			waitResponse()
			verifyTrue(hasVScrollbar(jq("@center")))
		})
	}
}
