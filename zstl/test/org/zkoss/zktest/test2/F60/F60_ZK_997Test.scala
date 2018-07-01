/* F60_ZK_997Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 14:14:07 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-997
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-997.zul,F60,SelectorComposer,EventQueue")
class F60_ZK_997Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>
					1. Click on each of the 'Publish' button. You should see two messages regarding to event receiving for each click.
				</div>
				<window	apply="org.zkoss.zktest.test2.F60_ZK_997_Composer">
					<div>
						Desktop: 
						<button id="dBtn" label="Publish" />
					</div>
					<div>
						Group: 
						<button id="gBtn" label="Publish" />
					</div>
					<div>
						Session: 
						<button id="sBtn" label="Publish" />
					</div>
					<div>
						Application: 
						<button id="aBtn" label="Publish" />
					</div>
					<div id="screen" />
				</window>
			</zk>

    """
    runZTL(zscript,
      () => {
        var dBtn: Widget = engine.$f("dBtn");
        var gBtn: Widget = engine.$f("gBtn");
        var sBtn: Widget = engine.$f("sBtn");
        var aBtn: Widget = engine.$f("aBtn");

        click(dBtn);
        sleep(1000);
        verifyTrue("Has 2 mesasges",
          jq(".z-label:contains(Event received through )").length() == 2);

        click(gBtn);
        sleep(1000);
        verifyTrue("Has 4 mesasges",
          jq(".z-label:contains(Event received through )").length() == 4);

        click(sBtn);
        sleep(1000);
        verifyTrue("Has 6 mesasges",
          jq(".z-label:contains(Event received through )").length() == 6);

        click(aBtn);
        sleep(1000);
        verifyTrue("Has 8 mesasges",
          jq(".z-label:contains(Event received through )").length() == 8);
      }
    );
  }
}