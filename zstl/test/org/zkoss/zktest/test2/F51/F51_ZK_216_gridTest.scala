/* F51_ZK_216_gridTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 17:11:47 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-216-grid
 * @author benbai
 *
 */
@Tags(tags = "F51-ZK-216-grid.zul,F60,A,E,template,grid")
class F51_ZK_216_gridTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
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
				<grid id="gbOne" model="${infos}">
					<template name="model">
						<row>
							<label value="${each[0]}"/>
							<label value="${each[1]}"/>
						</row>
					</template>
				</grid>
			
				<html><![CDATA[
				<ul><li>You shall see 20,000 items and each has two colums.</li></ul>
				]]></html>
				<zscript>
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(20000);
				</zscript>
				<grid id="gbTwo" height="200px" model="${strset}">
					<columns>
						<column label="Sequence" sort="auto"/>
						<column label="Options" sort="auto"/>
					</columns>
					<template name="model">
						<row>
							<label value="#${self.parent.index}"/><!-- performance is not good (for testing only) -->
							<label value=":${each}"/>
						</row>
					</template>
				</grid>
				<!-- used for debugging
				<zscript><![CDATA[
				public class MyRender implements RowRenderer {
					public void render(Row item, Object data, int index) {
						item.appendChild(new Label("#" + index)); //performance is not good (for testing only)
						item.appendChild(new Label(":" + data));
					}
				}
				RowRenderer render = new MyRender();
				]]></zscript>
				<grid height="200px" model="${strset}" rowRenderer="${render}">
					<columns>
						<column label="Sequence" sort="auto"/>
						<column label="Options" sort="auto"/>
					</columns>
				</grid>
				-->
			</window>

    """

   runZTL(zscript,
        () => {
        var gbOne: Widget = engine.$f("gbOne");
        var gbTwo: Widget = engine.$f("gbTwo");

        var bodyTwo: Element = gbTwo.$n("body");
        var scrollHeight: Int = Integer.parseInt(bodyTwo.get("scrollHeight"));

        // verify listitem contents
        def verifyItem (leftContent: String, rightContent: String, grid: Widget) {
          var lCell: JQuery = jq(grid.$n("body")).find(".z-row-cnt:contains("+leftContent+")");
          var rCell: JQuery = jq(grid.$n("body")).find(".z-row-cnt:contains("+rightContent+")");
          verifyTrue("item exist",
              lCell.exists() && rCell.exists()
              && lCell.offsetTop() == rCell.offsetTop());
        }

        verifyItem ("Apple", "10kg", gbOne);
        verifyItem ("Orange", "20kg", gbOne);
        verifyItem ("Mango", "12kg", gbOne);

        verifyItem ("#0", ":Option 0", gbTwo);
        bodyTwo.eval("scrollTop = " + scrollHeight/2);
        sleep(500);
        waitResponse();
        verifyItem ("#10005", ":Option 10005", gbTwo);
        bodyTwo.eval("scrollTop = " + scrollHeight);
        waitResponse();
        sleep(500);
        verifyItem ("#19999", ":Option 19999", gbTwo);
    }
   );
  }
}