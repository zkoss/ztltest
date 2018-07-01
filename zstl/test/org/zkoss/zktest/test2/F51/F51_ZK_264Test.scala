/* F51_ZK_264Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 16 10:50:47 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-264
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-264.zul,F60,A,E,event,listener")
class F51_ZK_264Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<vlayout>
			Click the following button, then check if six lines of Priorities will be shown as the following sequence:
			"Highest", "ZUML", "High", "Normal", "Normal", "Low"
			<button id="b" label="test"
			 onClick='self.parent.appendChild(new Label("ZUML Priority"))'/>
			<zscript>
			//org.zkoss.lang.Library.setProperty("org.zkoss.zk.ui.EventListener.duplicateIgnored", "true");
			EventListener li;
			b.addEventListener("onClick", li = new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Normal Priority"));
				}
			});
			b.addEventListener(-1, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Low Priority"));
				}
			});
			b.addEventListener(1, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("High Priority"));
				}
			});
			b.addEventListener("onClick", li);
			b.addEventListener(1000, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Highest Priority"));
				}
			});
			</zscript>
			</vlayout>

    """

    runZTL(zscript,
      () => {
        var btn: Widget = engine.$f("b");

        def checkSeq(before: String, after: String) {
          var lbOne: JQuery = jq(".z-label:contains(" + before + ")");
          var lbTwo: JQuery = jq(".z-label:contains(" + after + ")");
          if (before.equals(after))
            lbTwo = jq(jq(".z-label:contains(" + after + ")").get(1));

          verifyTrue("The labels should exist.",
            lbOne.exists() && lbTwo.exists());

          verifyTrue(before + " should before " + after,
            lbOne.offsetTop() < lbTwo.offsetTop());
        }

        click(btn);
        waitResponse();
        checkSeq("Highest Priority", "ZUML Priority");
        checkSeq("ZUML Priority", "High Priority");
        checkSeq("High Priority", "Normal Priority");
        checkSeq("Normal Priority", "Normal Priority");
        checkSeq("Normal Priority", "Low Priority");
      }
    );
  }
}