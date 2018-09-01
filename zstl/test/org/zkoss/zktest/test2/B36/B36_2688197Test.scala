/* B36_2688197Test.java

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


class B36_2688197Test extends ZTL4ScalaTestCase {
  @Test
  def testsize() = {
    var zscript =
      """
			<zk>
				<html><![CDATA[
				Test 3 Cases:
				<ol>
					<li>In IE 7, the popup have width but no height.</li>
					<li>In all browser, the popup have height but no width.</li>
					<li>In all browser, the popup have no height and no width</li>
				</ol>
				]]></html>
				<vbox>
					<hbox>
						<button label="set width">
							<attribute name="onClick"><![CDATA[
						 title.setWidth("300px");
					]]></attribute>
						</button>
						<button label="no width">
							<attribute name="onClick"><![CDATA[
						title.setWidth("");
					]]></attribute>
						</button>
						<button label="set height">
							<attribute name="onClick"><![CDATA[
						title.setHeight("100px");
					]]></attribute>
						</button>
						<button label="no height">
							<attribute name="onClick"><![CDATA[
						title.setHeight("");
					]]></attribute>
						</button>
					</hbox>
					<label value="Click me to Show Popup!" popup="title" />
				</vbox>
				<popup id="title">
					<html>Input the subject of this letter. Problem report :</html>
					<toolbarbutton label="ZK Forum" target="zkdemo"
						href="http://www.zkoss.org/forum" />
				</popup>

			</zk>
		"""
    val ztl$engine = engine()
    val title = ztl$engine.$f("title")
    runZTL(zscript, () => {
      var setWidth = jq("@button[label=\"set width\"]")
      var noWidth = jq("@button[label=\"no width\"]")
      var setHeight = jq("@button[label=\"set height\"]")
      var noHeight = jq("@button[label=\"no height\"]")
      var label = jq("@label")
      click(noWidth)
      waitResponse()
      click(setHeight)
      waitResponse()
      click(label)
      waitResponse()
      var pp = jq(title.$n())
      verifyEquals("have height", "100px", pp.toElement().attr("style.height"))
      verifyEquals("have no width", "", pp.toElement().attr("style.width"))
      click(noWidth)
      waitResponse()
      click(noHeight)
      waitResponse()
      click(label)
      waitResponse()
      verifyEquals("have no height", "", pp.toElement().attr("style.height"))
      verifyEquals("have no width", "", pp.toElement().attr("style.width"))
    })
  }
}



