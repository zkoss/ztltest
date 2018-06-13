/* F51_ZK_216Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 15:50:55 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-216
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-216.zul,F60,A,E,template,listbox")
class F51_ZK_216Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<window>
				<html><![CDATA[
				<ul><li>You shall see three items and each has two colums</li></ul>
				]]></html>
				<zscript>
				ListModel infos = new ListModelArray(
					new String[][] {
						{"Apple", "10kg"},
						{"Orange", "20kg"},
						{"Mango", "12kg"}
					});
				</zscript>			
				<listbox id="lbOne" model="${infos}">
					<template name="model">
						<listitem>
							<listcell label="${each[0]}"/>
							<listcell label="${each[1]}"/>
						</listitem>
					</template>
				</listbox>
			
				<html><![CDATA[
				<ul><li>You shall see 20,000 items and each has two colums.</li></ul>
				]]></html>
				<zscript>
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(20000);
				</zscript>
				<listbox id="lbTwo" rows="10" model="${strset}">
					<listhead>
						<listheader label="Sequence" sort="auto"/>
						<listheader label="Options" sort="auto"/>
					</listhead>
					<template name="model">
						<listitem>
							<listcell label="#${self.parent.index}"/>
							<listcell label=":${each}"/>
						</listitem>
					</template>
				</listbox>
    			<button id="btnOne" label="scroll to middle">
    				<attribute name="onClick">
    					Clients.evalJavaScript("jq('$lbTwo').find('.z-listbox-body').scrollTop(jq('$lbTwo').find('.z-listbox-body')[0].scrollHeight/2)");
    				</attribute>
    			</button>
    			<button id="btnTwo" label="scroll to bottom">
    				<attribute name="onClick">
    					Clients.evalJavaScript("jq('$lbTwo').find('.z-listbox-body').scrollTop(jq('$lbTwo').find('.z-listbox-body')[0].scrollHeight)");
    				</attribute>
    			</button>
				<!-- used for debugging
				<zscript><![CDATA[
				public class MyRender implements ListitemRenderer {
					public void render(Listitem item, Object data, int index) {
						item.appendChild(new Listcell("#" + index));
						item.appendChild(new Listcell(":" + data));
					}
				}
				ListitemRenderer render = new MyRender();
				]]></zscript>
				<listbox rows="10" model="${strset}" itemRenderer="${render}">
					<listhead>
						<listheader label="Sequence" sort="auto"/>
						<listheader label="Options" sort="auto"/>
					</listhead>
				</listbox>
				-->
			</window>

    """

    runZTL(zscript,
      () => {
        var lbOne: Widget = engine.$f("lbOne");
        var lbTwo: Widget = engine.$f("lbTwo");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var bodyTwo: Element = lbTwo.$n("body");
        var scrollHeight: Int = parseInt(bodyTwo.get("scrollHeight"));

        // verify listitem contents
        def verifyItem(leftContent: String, rightContent: String, listbox: Widget) {
          var lCell: JQuery = jq(listbox).find(".z-listcell:contains(" + leftContent + ")");
          var rCell: JQuery = jq(listbox).find(".z-listcell:contains(" + rightContent + ")");
          verifyTrue("item exist",
            lCell.exists() && rCell.exists()
              && lCell.offsetTop() == rCell.offsetTop());
        }

        verifyItem("Apple", "10kg", lbOne);
        verifyItem("Orange", "20kg", lbOne);
        verifyItem("Mango", "12kg", lbOne);

        verifyItem("#0", ":Option 0", lbTwo);

        verScroll(bodyTwo, .5)
        sleep(1000);
        verifyItem("#10000", ":Option 10000", lbTwo);

        verScroll(bodyTwo, 1)
        sleep(1000);
        verifyItem("#19999", ":Option 19999", lbTwo);
      }
    );
  }
}