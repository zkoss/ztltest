/* B35_2075728Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2075728
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2075728.zul,A,E,Portallayout")
class B35_2075728Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
    		<window title="Test PortalLayout" border="normal">
	<groupbox open="false"><caption label="instructions(click to open)"/><html><![CDATA[  
Test Protal base Functionativity <br/>
1.After initl, there should have 4 column, column 1 and 3 is empty <br/>
2.Click button, then element in column 2, 4 should mvoe to column 1, 2 <br/>
3.You should able to darg any panel to column 3,4 still. <br/>
]]></html></groupbox>
	<zscript><![CDATA[//@IMPORT
	]]>
	<![CDATA[//@DECLARATION
	]]>
	<![CDATA[
	]]></zscript>
	<button id="btn" label="move" onClick="p1.parent=c1;p2.parent=c1;p3.parent=c2;p4.parent=c2"/>
	<portallayout>
		<portalchildren width="25%" id="c1">
		</portalchildren>
		<portalchildren width="25%" id="c2">
			<panel height="70px" title="Bandbox" id="p1">
				<panelchildren id="pc1">
					AA
				</panelchildren>
			</panel>
			<panel height="200px" title="Combobox" id="p2">
				<panelchildren id="pc2">
					BB
				</panelchildren>
			</panel>
		</portalchildren>
		<portalchildren width="25%" id="c3">
		</portalchildren>
		<portalchildren width="25%" id="c4">
			<panel height="70px" title="Bandbox" id="p3">
				<panelchildren id="pc3">
					CC
				</panelchildren>
			</panel>
			<panel height="200px" title="Combobox" id="p4">
				<panelchildren id="pc4">
					DD
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</window>
    """

    runZTL(zscript,
      () => {
        waitResponse()

        //Portal Columns
        val c1 = jq("$c1")
        val c2 = jq("$c2")
        val c3 = jq("$c3")
        val c4 = jq("$c4")

        //1-check if there are 4 columns
        verifyTrue(c1.exists())
        verifyTrue(c2.exists())
        verifyTrue(c3.exists())
        verifyTrue(c4.exists())

        //check childrens, column 1 and 3 empty
        verifyTrue(c1.toWidget.nChildren() == 0)
        verifyTrue(c2.toWidget.nChildren() > 0)
        verifyTrue(c3.toWidget.nChildren() == 0)
        verifyTrue(c4.toWidget.nChildren() > 0)

        //click button "move" to move items
        click(jq("@button"))

        waitResponse()

        //2-check move
        //Panel 1 & 2 move from col2 to col1
        verifyTrue(c1.toWidget.nChildren() > 0)
        verifyEquals(c1.toWidget.firstChild().id(), "p1")
        verifyEquals(c1.toWidget.lastChild().id(), "p2")

        //Panel 3 & 4 move from col4 to col2
        verifyTrue(c2.toWidget.nChildren() > 0)
        verifyEquals(c2.toWidget.firstChild().id(), "p3")
        verifyEquals(c2.toWidget.lastChild().id(), "p4")

        //Check Col3 & Col4 are empty
        verifyTrue(c3.toWidget.nChildren() == 0)
        verifyTrue(c4.toWidget.nChildren() == 0)

        //3-drag & drop
        val l = c3.offsetLeft()
        val t = 10

        dragdropTo(jq(".z-panel-header-move:eq(0)"), c1.offsetLeft() + "," + t, l + "," + t)

        waitResponse()

        //Verify panel1 is in c3
        verifyTrue(c1.toWidget.nChildren() == 1)
        verifyEquals(c1.toWidget.firstChild().id(), "p2")
        verifyTrue(c3.toWidget.nChildren() == 1)
        verifyEquals(c3.toWidget.firstChild().id(), "p1")

      }
    );
  }
}
