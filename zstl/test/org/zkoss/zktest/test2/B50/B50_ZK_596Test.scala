/* B50_ZK_596Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Dec 01 18:38:44 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import java.lang._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{ClientWidget, JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-596
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-596.zul,B,E,Tabbox,Toolbar")
class B50_ZK_596Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
		<zk>
		<div height="25px">1. Click the buttons below from left to right. </div>
		<div height="25px">2. The header of tabbox should shrink or expand while</div>
		<hbox><div height="25px" width="20px"></div><div height="25px"> the toolbar expand or shrink.</div></hbox>
			<tabbox id="tb" width="1000px">
				<tabs id="tbs">
					<tab label="Tab 1" closable="true" />
					<tab label="Tab 2" closable="true"/>
					<tab label="Tab 3" closable="true" />
					<tab label="Tab 4" closable="true"/>
					<tab label="Tab 5" closable="true"/>
				</tabs>
				<toolbar id="tbar">
					<toolbarbutton id="img1" image="/img/live.gif" />
					<toolbarbutton id="img2" image="/img/defender.gif" />
					<toolbarbutton id="img3" image="/img/battery.gif" />
					<toolbarbutton id="img4" image="/img/live.gif" />
					<toolbarbutton id="img5" image="/img/defender.gif" />
					<toolbarbutton id="img9" image="/img/defender.gif" />
					<toolbarbutton id="img10" image="/img/battery.gif" />
					<toolbarbutton id="img11" image="/img/live.gif" />
					<toolbarbutton id="img12" image="/img/defender.gif" />
				</toolbar>
				<tabpanels>
					<tabpanel>This is panel 1</tabpanel>
					<tabpanel>This is panel 2	The second panel</tabpanel>
					<tabpanel>This is panel 3</tabpanel>
					<tabpanel>This is panel 4</tabpanel>
					<tabpanel>This is panel 5</tabpanel>
				</tabpanels>
			</tabbox>
			<button id="btn1" label="hide button">
				<attribute name="onClick">
					img1.setVisible(false);
					img2.setVisible(false);
				</attribute>
			</button>
			<button id="btn2" label="show button">
				<attribute name="onClick">
					img1.setVisible(true);
					img2.setVisible(true);
				</attribute>
			</button>
			<button id="btn3" label="add button">
				<attribute name="onClick">
					Toolbarbutton tb = new Toolbarbutton();
					tb.setId("img6");
					tb.setImage("/img/battery.gif");
					tb.setParent(tbar);
			
					tb = new Toolbarbutton();
					tb.setId("img7");
					tb.setImage("/img/live.gif");
					tb.setParent(tbar);
			
					tb = new Toolbarbutton();
					tb.setId("img8");
					tb.setImage("/img/defender.gif");
					tb.setParent(tbar);
				</attribute>
			</button>
			<button id="btn4" label="remove button">
				<attribute name="onClick">
					img6.setParent(null);
					img7.setParent(null);
					img8.setParent(null);
				</attribute>
			</button>
			<button id="btn5" label="shrink toolbar width">
				<attribute name="onClick">
					tbar.setWidth("200px");
				</attribute>
			</button>
			<button id="btn6" label="enlarge toolbar width">
				<attribute name="onClick">
					tbar.setWidth("400px");
				</attribute>
			</button>
		</zk>
    """


    runZTL(zscript, () => {
      var tb: Widget = engine.$f("tb")
      var tbs: Widget = engine.$f("tbs")
      var tbar: Widget = engine.$f("tbar")
      var btn1: Widget = engine.$f("btn1")
      var btn2: Widget = engine.$f("btn2")
      var btn3: Widget = engine.$f("btn3")
      var btn4: Widget = engine.$f("btn4")
      var btn5: Widget = engine.$f("btn5")
      var btn6: Widget = engine.$f("btn6")
      def clickAndWait = (target: ClientWidget) => {
        click(target)
        sleep(1000)
      }
      // add image and wait to load them all
      clickAndWait(btn3)
      sleep(2000)
      clickAndWait(btn4)

      var $tb: JQuery = jq(tb.$n())
      var $tbs: JQuery = jq(tbs.$n())
      var $tbar: JQuery = jq(tbar.$n())

      def checkWidth = () => {
        verifyTrue("the sum of tabs header width and toolbar width should smaller or equal to tabs width",
          $tbs.outerWidth(true) + $tbar.outerWidth(true) <= $tb.outerWidth())
      }

      clickAndWait(btn1)
      checkWidth()
      clickAndWait(btn2)
      checkWidth()
      clickAndWait(btn3)
      checkWidth()
      clickAndWait(btn4)
      checkWidth()
      clickAndWait(btn5)
      checkWidth()
      clickAndWait(btn6)
      checkWidth()
    })
  }
}