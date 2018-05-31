/* B50_ZK_454Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_ZK_454Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				Please click the following buttons by 1, 2, and 3.
				<separator/>
				Then you shouldn't see any JS error.
				<tabbox id="tab">
					<tabs id="tabs"/>
					<tabpanels id="tps" />
				</tabbox>
				<grid id="grid" />
				<button id="btn1" label="1">
					<attribute name="onClick">
					tabs.appendChild(new Tab("x"));
					tabs.appendChild(new Tab("y"));
					Tabpanel tp = new Tabpanel();
					tp.appendChild(new Label("x"));
					Tabpanel tp1 = new Tabpanel();
					tp1.appendChild(new Label("xx"));
					tps.appendChild(tp);
					tps.appendChild(tp1);
					</attribute>
				</button>
				
				<button id="btn2" label="2">
					<attribute name="onClick">
					tabs.getChildren().clear();
					tps.getChildren().clear();
					tabs.appendChild(new Tab("x"));
					tabs.appendChild(new Tab("y"));
					Tabpanel tp = new Tabpanel();
					tp.appendChild(new Label("x"));
					Tabpanel tp1 = new Tabpanel();
					tp1.appendChild(new Label("xx"));
					tps.appendChild(tp);
					tps.appendChild(tp1);
					//tab.invalidate(); //workaround
					</attribute>
				</button>
				<button id="btn3" label="3">
					<attribute name="onClick">
					Columns cls = new Columns();
					Column c1 = new Column("x");
					Column c2 = new Column("x");
					Column c3 = new Column("x");
					Column c4 = new Column("x");
					cls.setParent(grid);
					c1.setParent(cls);
					c2.setParent(cls);
					c3.setParent(cls);
					c4.setParent(cls);
					</attribute>
				</button>
				
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tab = ztl$engine.$f("tab")
    val tabs = ztl$engine.$f("tabs")
    val tps = ztl$engine.$f("tps")
    val grid = ztl$engine.$f("grid")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    runZTL(zscript, () => {
      click(btn1)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(btn2)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(btn3)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



